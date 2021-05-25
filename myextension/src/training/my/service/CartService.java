package training.my.service;

import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.model.ModelService;
import training.my.event.MyEvent;

import javax.annotation.Resource;

public class CartService {
    @Resource
    EventService eventService;

    @Resource
    ModelService modelService;

    public void addCartModel(CartModel cartModel) {
        modelService.save(cartModel);
        eventService.publishEvent(new MyEvent());
    }
}
