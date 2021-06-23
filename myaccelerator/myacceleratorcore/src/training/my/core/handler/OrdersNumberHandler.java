package training.my.core.handler;

import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;
import training.my.core.model.CurrentNumberOfOrdersModel;

import training.my.service.MyUserService;

import javax.annotation.Resource;

public class OrdersNumberHandler implements DynamicAttributeHandler<Integer, CurrentNumberOfOrdersModel>{

    @Resource
    MyUserService myUserService;

    @Override
    public Integer get(CurrentNumberOfOrdersModel model) {
        return myUserService.getTotalNumberOfOrders();

    }

    @Override
    public void set(CurrentNumberOfOrdersModel model, Integer integer) {
        model.setNumberOfOrders(integer);
    }

}
