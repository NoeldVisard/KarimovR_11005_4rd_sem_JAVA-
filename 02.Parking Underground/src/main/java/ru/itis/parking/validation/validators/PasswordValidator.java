package ru.itis.parking.validation.validators;

import lombok.RequiredArgsConstructor;
import ru.itis.parking.validation.annotations.PasswordEqual;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@RequiredArgsConstructor
public class PasswordValidator implements ConstraintValidator<PasswordEqual, Object> {

    private String[] fields;
    private final ObjectFields getFieldObject;

    @Override
    public void initialize(PasswordEqual constraintAnnotation) {
        this.fields = constraintAnnotation.names();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        List<String> fieldValues = getFieldObject.getFieldValues(object, fields);
        return fieldValues.size() != fieldValues.stream().distinct().count();
    }
}
