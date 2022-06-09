package ru.itis.parking.validation.validators.Impl;

import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Component;
import ru.itis.parking.validation.validators.ObjectFields;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
public class ObjectFieldsImpl implements ObjectFields {

    @Override
    public List<String> getFieldValues(Object object, String[] fields) {
        List<String> fieldValues = new ArrayList<>();
        for (String fieldName : fields) {
            try {
                Field field = ReflectionUtils.findRequiredField(object.getClass(), fieldName);
                field.setAccessible(true);
                fieldValues.add((String) field.get(object));
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return fieldValues;
    }

}
