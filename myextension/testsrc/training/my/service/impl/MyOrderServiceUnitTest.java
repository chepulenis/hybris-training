package training.my.service.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.UserModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@UnitTest
public class MyOrderServiceUnitTest{

    @Mock
    private MyOrderServiceImpl myOrderService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnTotalNumberOfOrders(){
        int expected = 5;
        when(myOrderService.getTotalNumberOfOrders()).thenReturn(5);
        assertEquals(expected, myOrderService.getTotalNumberOfOrders());
    }

    @Test
    public void shouldReturnLastOrder() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2006-09-17 10:58:00");
        OrderModel expected = new OrderModel();
        expected.setDate(date);
        OrderModel actual = Mockito.mock(OrderModel.class);
        when(myOrderService.getLastOrder()).thenReturn(expected);
        assertEquals(expected.getDate(), myOrderService.getLastOrder().getDate());
    }

    @Test
    public void shouldReturnUserWithMostOrders(){
        List<UserModel> expected = Mockito.mock(List.class);
        UserModel user1 = new UserModel();
        user1.setName("John");
        UserModel user2 = new UserModel();
        user1.setName("Robert");
        when(expected.get(0)).thenReturn(user1);
        when(expected.get(1)).thenReturn(user2);
        assertEquals(expected.get(0).getName(), user1.getName());
        assertEquals(expected.get(1).getName(), user2.getName());
    }
}
