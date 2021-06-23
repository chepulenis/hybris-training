package training.my.storefront.controllers.cms;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.cms.AbstractCMSComponentController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import training.my.core.model.CurrentNumberOfUsersModel;
import training.my.storefront.controllers.ControllerConstants;

import javax.servlet.http.HttpServletRequest;

@Controller("CurrentNumberOfUsersController")
@RequestMapping(value = ControllerConstants.Actions.Cms.CurrentNumberOfUsers)
public class CurrentNumberOfUsersController extends AbstractCMSComponentController<CurrentNumberOfUsersModel> {
    @Override
    protected void fillModel(HttpServletRequest request, Model model, CurrentNumberOfUsersModel component) {
        model.addAttribute("usersHeaderText", component.getUsersHeaderText());
        model.addAttribute("numberOfUsers", component.getNumberOfUsers());
    }

    @Override
    protected String getView(CurrentNumberOfUsersModel component) {
        return null;
    }
}
