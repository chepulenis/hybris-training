package training.my.storefront.controllers.pages.checkout.steps;

import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import training.my.storefront.controllers.pages.AccountPageController;

@Controller
@Scope("tenant")
@RequestMapping("usersAndOrders")
public class UsersAndOrdersController extends AccountPageController {
    private static final String USERS_AND_ORDERS_PAGE = "UsersAndOrdersCMSPage";

    @GetMapping("/")
    public String getTaskSixCmsPage(Model model) throws CMSItemNotFoundException {
        ContentPageModel contentPageModel = getContentPageForLabelOrId(USERS_AND_ORDERS_PAGE);
        storeCmsPageInModel(model, contentPageModel);
        setUpMetaDataForContentPage(model,contentPageModel);
        return getViewForPage(model);
    }
}
