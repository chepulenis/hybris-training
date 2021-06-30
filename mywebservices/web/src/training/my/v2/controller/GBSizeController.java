package training.my.v2.controller;

import de.hybris.platform.cmsfacades.data.ProductData;

import de.hybris.platform.commercewebservicescommons.dto.product.ProductListWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.ProductWsDTO;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import training.my.service.GbSizeService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/{baseSiteId}", headers = "Accept=application/xml,application/json")
public class GBSizeController extends BaseCommerceController {

    @Resource
    GbSizeService gbSizeService;

    @RequestMapping(value = "/findProducts", method = RequestMethod.GET)
    @ResponseBody
    public ProductListWsDTO findOrderedByGBProducts(){
        ProductListWsDTO result = new ProductListWsDTO();
        List<ProductWsDTO> productsDto = new ArrayList<>();

        List<ProductModel> products = gbSizeService.getProductsOrderedByGBSize();

        for (ProductModel product : products){
            ProductWsDTO productWsDTO = new ProductWsDTO();
            productWsDTO.setCode(product.getCode());
            productWsDTO.setName(product.getName());
            productsDto.add(productWsDTO);
        }
        result.setProducts(productsDto);

        return result;
    }

}
