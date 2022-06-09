package ru.itis.parking.validation.validators;

import java.util.List;

public interface ObjectFields {
    List<String> getFieldValues(Object object, String[] fields);
}
