package training.my.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserAgeValidator implements ConstraintValidator<UserAgeUnder21, Integer> {

    @Override
    public void initialize(UserAgeUnder21 constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return integer > 21;
    }
}
