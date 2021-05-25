package training.my.service;

import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import javax.annotation.Resource;

public class MyUserService {

    @Resource
    FlexibleSearchService flexibleSearchService;

    public int getTotalNumberOfUsers() {
        String query = "select {pk} from {user}";
        SearchResult<UserModel> searchResult = flexibleSearchService.search(query);
        return searchResult.getCount();
    }
}
