package ru.neshin.posta.service.converters;

import com.fasterxml.jackson.databind.JsonNode;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public interface BaseConverter<T, J extends Map> {
    default T doAction(final J mapJson, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        final T result = clazz.newInstance();
        final List<Field> fieldList = Arrays.asList(result.getClass().getDeclaredFields());
        mapJson.forEach((key, valueMap) -> {
            return;
        });
        fieldList.forEach((value) -> {
            String valueName = value.getName();
            System.out.println(valueName);
        });
        return result;
    }
}
