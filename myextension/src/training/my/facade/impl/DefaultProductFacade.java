package training.my.facade.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.jalo.order.price.PriceInformation;
import de.hybris.platform.product.PriceService;
import de.hybris.platform.product.ProductService;
import training.my.data.PriceData;
import training.my.data.ProductData;
import training.my.facade.ProductFacade;

import java.util.List;

public class DefaultProductFacade implements ProductFacade {
    private ProductService productService;
    private PriceService priceService;


    @Override
    public ProductData getProduct(String productCode) {
        ProductModel product = productService.getProductForCode(productCode);
        List<PriceInformation> prices = priceService.getPriceInformationsForProduct(product);
        ProductData productData = new ProductData();
        productData.setCode(product.getCode());
        productData.setDescription(product.getDescription());
        productData.setName(product.getName());
        if (product.getPicture() != null)
        {
            productData.setPictureUrl(product.getPicture().getURL());
        }
        if (!prices.isEmpty())
        {
            PriceInformation price = prices.iterator().next();
            PriceData priceData = new PriceData();
            priceData.setCurrency(price.getPriceValue().getCurrencyIso());
            priceData.setValue(price.getPriceValue().getValue());
            productData.setPrice(priceData);
        }
        return productData;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    public void setPriceService(PriceService priceService) {
        this.priceService = priceService;
    }
}
