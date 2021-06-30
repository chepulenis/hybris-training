package training.my.service;

import de.hybris.platform.cmsfacades.data.ProductData;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import javax.annotation.Resource;
import java.util.List;

public class LastUsersService {

    @Resource
    FlexibleSearchService flexibleSearchService;

    @Resource
    ProductFacade productFacade;

    public List<UserModel> getLastUsersIn24Hours() {
        final String query = "select {pk} from {user} where {user.creationTime} > now() - interval 1 day";
        SearchResult<UserModel> searchResult = flexibleSearchService.search(query);

        return searchResult.getResult();
    }

}
