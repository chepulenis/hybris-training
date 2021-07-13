package service;


import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.UserModel;

public interface MyOrderService {
    int getTotalNumberOfOrders();
    OrderModel getLastOrder();
    UserModel getUserWithMostOrders();
}
