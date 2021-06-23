package training.my.core.search.solrfacetsearch.provider.impl;

import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.ValueRangeSet;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.provider.FieldNameProvider;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;
import de.hybris.platform.solrfacetsearch.provider.FieldValueProvider;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractPropertyFieldValueProvider;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

public class ProductCustomSizeValueProvider extends AbstractPropertyFieldValueProvider implements FieldValueProvider, Serializable
{
    private static final Logger LOG = Logger.getLogger(ProductCustomSizeValueProvider.class);

    private FieldNameProvider fieldNameProvider;
    @Override
    public Collection<FieldValue> getFieldValues(final IndexConfig indexConfig, final IndexedProperty indexProperty,
                                                 final Object model) throws FieldValueProviderException
    {
            if (model instanceof ProductModel)
            {
                final ProductModel product = (ProductModel) model;
                final List<FieldValue> fieldValues = addFieldValues(indexProperty, indexConfig, product);
                addFieldValues(indexProperty, indexConfig, product);
                return fieldValues;
            }
            else throw new FieldValueProviderException("No Product found for indexing");

    }

    protected List<FieldValue> addFieldValues(final IndexedProperty indexedProperty, final IndexConfig indexConfig,
                                   final ProductModel productModel)
    {
        final List<FieldValue> fieldValues = new ArrayList<FieldValue>();
        final Double customSize = productModel.getCustomSize();
        final Collection<String> fieldNames = getFieldNameProvider().getFieldNames(indexedProperty,
                null);
        for (final String fieldName : fieldNames)
        {
            fieldValues.add(new FieldValue(fieldName, customSize));

        }
        return fieldValues;
    }

//    protected List getValueRanges(final IndexedProperty property, final String qualifier)
//    {
//        ValueRangeSet valueRangeSet;
//        if (qualifier == null)
//        {
//            valueRangeSet = property.getValueRangeSets().get("default");
//        }
//        else
//        {
//            valueRangeSet = property.getValueRangeSets().get(qualifier);
//            if (valueRangeSet == null)
//            {
//                valueRangeSet = property.getValueRangeSets().get("default");
//            }
//        }
//        if (valueRangeSet != null)
//        {
//            return valueRangeSet.getValueRanges();
//        }
//        else
//        {
//            return Collections.emptyList();
//        }
//    }



    public FieldNameProvider getFieldNameProvider()
    {
        return fieldNameProvider;
    }

    public void setFieldNameProvider(final FieldNameProvider fieldNameProvider)
    {
        this.fieldNameProvider = fieldNameProvider;
    }
}