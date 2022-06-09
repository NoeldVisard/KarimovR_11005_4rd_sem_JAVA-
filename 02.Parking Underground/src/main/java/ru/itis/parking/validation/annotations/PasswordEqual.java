package ru.itis.parking.validation.annotations;

import ru.itis.parking.validation.validators.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordEqual {
    String message() default "same password";

    String[] names() default {};

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
