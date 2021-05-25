package training.my.service.impl;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.impex.jalo.ImpExException;
import de.hybris.platform.servicelayer.ServicelayerTest;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@IntegrationTest
public class MyOrderServiceIntegrationTest extends ServicelayerTest{

    @Resource
    private MyOrderServiceImpl myOrderService;

    @Before
    public void setUp(){
        try {
            importCsv("/impex/second_module_tests.impex","utf-8");
        } catch (ImpExException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldReturnTotalNumberOfOrders(){
        int actual = myOrderService.getTotalNumberOfOrders();
        assertEquals(5, actual);
    }

    @Test
    public void shouldReturnLastOrder() throws ParseException {
        OrderModel actual = myOrderService.getLastOrder();
        Date expected = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2006-09-17 10:58:00");
        assertEquals(expected, actual.getDate());
    }

    @Test
    public void getUserWithMostOrders(){
        UserModel actual = myOrderService.getUserWithMostOrders();
        assertEquals("user1", actual.getUid());
    }

}
