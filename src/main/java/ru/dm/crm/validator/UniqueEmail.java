package ru.dm.crm.validator;

/**
 * Created by Denis on 31.03.18.
 */

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueEmailValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {

    String message() default "Данный email уже существует";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}