package search.solrfacetsearch.impl;

import de.hybris.platform.commerceservices.search.solrfacetsearch.data.AutocompleteSuggestion;
import de.hybris.platform.commerceservices.search.solrfacetsearch.impl.DefaultSolrProductSearchAutocompleteService;

import java.util.List;

public class CustomSolrProductSearchAutocompleteService extends DefaultSolrProductSearchAutocompleteService {

    @Override
    public List<AutocompleteSuggestion> getAutocompleteSuggestions(String input) {
        return super.getAutocompleteSuggestions(input.split(" ")[0]);
    }
}
