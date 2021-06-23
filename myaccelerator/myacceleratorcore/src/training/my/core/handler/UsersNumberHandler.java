package training.my.core.handler;

import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;
import training.my.core.model.CurrentNumberOfUsersModel;
import training.my.service.MyUserService;

import javax.annotation.Resource;

public class UsersNumberHandler implements DynamicAttributeHandler<Integer, CurrentNumberOfUsersModel> {

    @Resource
    MyUserService myUserService;

    @Override
    public Integer get(CurrentNumberOfUsersModel model) {
        return myUserService.getTotalNumberOfUsers();

    }

    @Override
    public void set(CurrentNumberOfUsersModel model, Integer integer) {
        model.setNumberOfUsers(integer);
    }
}
