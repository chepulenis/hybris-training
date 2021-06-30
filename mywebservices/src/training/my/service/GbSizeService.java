package training.my.service;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import javax.annotation.Resource;
import java.util.List;

public class GbSizeService {

    @Resource
    FlexibleSearchService flexibleSearchService;

    public List<ProductModel> getProductsOrderedByGBSize() {
        final String query = "select {pk} from {product} order by {product.gbsize}";
        SearchResult<ProductModel> searchResult = flexibleSearchService.search(query);
        return searchResult.getResult();
    }

}
