package training.my.storefront.controllers.cms;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.cms.AbstractCMSComponentController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import training.my.core.model.CurrentNumberOfOrdersModel;
import training.my.storefront.controllers.ControllerConstants;

import javax.servlet.http.HttpServletRequest;

@Controller("CurrentNumberOfOrdersController")
@RequestMapping(value = ControllerConstants.Actions.Cms.CurrentNumberOfOrders)
public class CurrentNumberOfOrdersController extends AbstractCMSComponentController<CurrentNumberOfOrdersModel> {
    @Override
    protected void fillModel(HttpServletRequest request, Model model, CurrentNumberOfOrdersModel component) {
        model.addAttribute("ordersHeaderText", component.getOrdersHeaderText());
        model.addAttribute("numberOfOrders", component.getNumberOfOrders());
    }

    @Override
    protected String getView(CurrentNumberOfOrdersModel component) {
        return null;
    }
}
