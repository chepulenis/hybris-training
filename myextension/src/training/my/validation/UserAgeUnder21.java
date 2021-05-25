package training.my.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserAgeValidator.class)
@Documented
public @interface UserAgeUnder21
{
    String message() default "{training.my.validation.UserAgeUnder21.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}