package training.my.service;

import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.order.CartService;
import de.hybris.platform.order.InvalidCartException;
import de.hybris.platform.order.OrderService;
import de.hybris.platform.processengine.BusinessProcessEvent;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.product.UnitService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.user.UserService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MyBusinessProcessService {
    @Resource
    private BusinessProcessService businessProcessService;
    @Resource
    private CartService cartService;
    @Resource
    private OrderService orderService;
    @Resource
    private FlexibleSearchService flexibleSearchService;
    @Resource
    private ModelService modelService;
    @Resource
    private ProductService productService;
    @Resource
    private UnitService unitService;
    @Resource
    private UserService userService;

    public void addProductToTheCart(String productCode, String cartCode, Long quantity, String unitCode) {

        ProductModel productModel = productService.getProductForCode(productCode);
        UnitModel unitModel = unitService.getUnitForCode(unitCode);

        final FlexibleSearchQuery cartFlexibleSearchQuery = new FlexibleSearchQuery("SELECT {PK} FROM {cart} WHERE {code}=?cartCode");
        cartFlexibleSearchQuery.addQueryParameter("cartCode", cartCode);
        cartFlexibleSearchQuery.setDisableCaching(true);
        SearchResult<CartModel> cartModelSearchResult = flexibleSearchService.search(cartFlexibleSearchQuery);

        if(cartModelSearchResult.getCount() == 0) {
            UserModel userModel = userService.getUserForUID("anonymous");

            final String currencyQuery = "SELECT {PK} FROM {currency} WHERE {isocode}='EUR'";
            SearchResult<CurrencyModel> resultCurrency = flexibleSearchService.search(currencyQuery);
            CurrencyModel currencyModel = resultCurrency.getResult().get(0);

            Date currentTime = new Date();
            CartModel newCartModel = modelService.create(CartModel.class);
            newCartModel.setCode(cartCode);
            newCartModel.setDate(currentTime);
            newCartModel.setUser(userModel);
            newCartModel.setCurrency(currencyModel);
            modelService.save(newCartModel);
            cartService.addNewEntry(newCartModel, productModel, quantity, unitModel);
            cartService.setSessionCart(newCartModel);
            cartService.saveOrder(newCartModel);
        }else {
            CartModel cartModel = cartModelSearchResult.getResult().get(0);
            cartService.addNewEntry(cartModel, productModel, quantity, unitModel);
            cartService.setSessionCart(cartModel);
            cartService.saveOrder(cartModel);
        }
        businessProcessService.startProcess(productCode + cartCode + quantity, "placeorder");
    }

    public void removeProductOrCart(String codeProduct) {
        CartModel cartModelSession = cartService.getSessionCart();
        if(codeProduct != null) {
            List<AbstractOrderEntryModel> listSession = cartModelSession.getEntries();
            listSession = listSession.stream().filter(p -> p.getProduct().getCode().equals(codeProduct)).collect(Collectors.toList());
            cartModelSession.setEntries(listSession);
            cartService.saveOrder(cartModelSession);
        }else {
            cartService.removeSessionCart();
        }
        final BusinessProcessEvent event = BusinessProcessEvent.builder("eventWithChoice").withChoice("remove_order").build();
        businessProcessService.triggerEvent(event);
    }

    public void placeOrder() throws InvalidCartException {
        CartModel cartModel = cartService.getSessionCart();
        OrderModel orderModel = orderService.createOrderFromCart(cartModel);
        orderService.submitOrder(orderModel);
        final BusinessProcessEvent event = BusinessProcessEvent.builder("eventWithChoice").withChoice("place_order").build();
        businessProcessService.triggerEvent(event);
    }


}
