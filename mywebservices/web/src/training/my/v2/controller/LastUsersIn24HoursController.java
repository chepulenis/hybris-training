package training.my.v2.controller;

import de.hybris.platform.commercewebservicescommons.dto.user.UserWsDTO;
import de.hybris.platform.core.model.user.UserModel;

import de.hybris.platform.servicelayer.internal.converter.impl.VariantProductModelConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import training.my.returns.data.UsersListWsDTO;
import training.my.service.LastUsersService;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/{baseSiteId}", headers = "Accept=application/xml,application/json")
public class LastUsersIn24HoursController extends BaseCommerceController {

    @Resource
    LastUsersService lastUsersService;

    @RequestMapping(value = "/findUsers", method = RequestMethod.GET)
    @ResponseBody
    public UsersListWsDTO findLastUsers(){
        UsersListWsDTO result = new UsersListWsDTO();
        List<UserWsDTO> usersDto = new ArrayList<>();

        List<UserModel> users = lastUsersService.getLastUsersIn24Hours();

        for (UserModel userModel : users){
            UserWsDTO userWsDTO = new UserWsDTO();
            userWsDTO.setUid(userModel.getUid());
            userWsDTO.setName(userModel.getName());
            usersDto.add(userWsDTO);
        }
        result.setUsersWsDTOList(usersDto);
        return result;
    }


}
