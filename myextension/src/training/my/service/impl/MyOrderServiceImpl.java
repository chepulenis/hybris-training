package training.my.service.impl;

import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import training.my.service.MyOrderService;

import javax.annotation.Resource;
import java.util.Collections;

public class MyOrderServiceImpl implements MyOrderService {

    private final String LAST_ORDER_QUERY = "select {pk} from {order} where {order.date} in ({{select max({order.date}) from {order}}})";
    private final String TOTAL_NUMBER_OF_ORDERS_QUERY = "select count({pk}) from {order}";
    private final String USER_WITH_MOST_ORDERS = "select {user} from {order} group by {user} having count(*) = ({{select count(*) from {order} group by {user} order by count(*) desc limit 1}})";

    @Resource
    private FlexibleSearchService flexibleSearchService;

    @Override
    public OrderModel getLastOrder() {
        FlexibleSearchQuery flexibleSearchQuery = new FlexibleSearchQuery(LAST_ORDER_QUERY);
        flexibleSearchQuery.setResultClassList(Collections.singletonList(OrderModel.class));
        SearchResult<OrderModel> orderList = flexibleSearchService.search(flexibleSearchQuery);
        return orderList.getResult().get(0);
    }

    public int getTotalNumberOfOrders() {
        FlexibleSearchQuery flexibleSearchQuery = new FlexibleSearchQuery(TOTAL_NUMBER_OF_ORDERS_QUERY);
        flexibleSearchQuery.setResultClassList(Collections.singletonList(Integer.class));
        SearchResult<Integer> result = flexibleSearchService.search(flexibleSearchQuery);
        return result.getResult().get(0);
    }

    @Override
    public UserModel getUserWithMostOrders() {
        FlexibleSearchQuery flexibleSearchQuery = new FlexibleSearchQuery(USER_WITH_MOST_ORDERS);
        flexibleSearchQuery.setResultClassList(Collections.singletonList(UserModel.class));
        SearchResult<UserModel> result = flexibleSearchService.search(flexibleSearchQuery);
        return result.getResult().get(0);
    }
}
