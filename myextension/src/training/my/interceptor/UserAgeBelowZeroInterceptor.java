package training.my.interceptor;

import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;

public class UserAgeBelowZeroInterceptor implements ValidateInterceptor {
    @Override
    public void onValidate(Object o, InterceptorContext interceptorContext) throws InterceptorException {
        if (o instanceof UserModel){
            final UserModel user = (UserModel) o;
            if (user.getAge() <= 0){
                throw new InterceptorException("User age cannot be equal or lower than zero");
            }
        }
    }
}
