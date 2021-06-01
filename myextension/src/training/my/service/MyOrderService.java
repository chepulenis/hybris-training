package training.my.service;


import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.UserModel;

public interface MyOrderService {
    public int getTotalNumberOfOrders();
    public OrderModel getLastOrder();
    public UserModel getUserWithMostOrders();
}
