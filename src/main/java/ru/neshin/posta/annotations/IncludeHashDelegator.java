package ru.neshin.posta.annotations;

import java.util.Arrays;

public interface IncludeHashDelegator {
    default String getCustomHash() {
        Class<?> clazz = this.getClass();
        final StringBuilder result = new StringBuilder();

        Arrays.stream(clazz.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(IncludeHash.class))
                .forEach(field -> {
                    try {
                        IncludeHash fieldAnnotation = field.getAnnotation(IncludeHash.class);
                        String name = field.getName();
                        if (!fieldAnnotation.alias().isEmpty()) {
                            name = fieldAnnotation.alias();
                        }
                        result.append(name);
                        result.append("=");
                        field.setAccessible(true);
                        Object obj = field.get(this);
                        result.append(obj != null ? obj.toString() : "NULL");
                        field.setAccessible(false);
                        System.out.println(result.toString());
                        System.out.println(org.apache.commons.codec.digest.DigestUtils.md5Hex(result.toString()).toUpperCase());
                    } catch (IllegalAccessException e) {
                        System.out.println(e.getMessage());
                    }
                });

        return org.apache.commons.codec.digest.DigestUtils.md5Hex(result.toString()).toUpperCase();
    }
}
