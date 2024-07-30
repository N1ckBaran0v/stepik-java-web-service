package com.github.N1ckBaran0v;

import java.lang.reflect.Field;

public class ReflectionHelper {
    public static Object createInstance(String className) {
        try {
            return Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setFieldValue(Object object, String fieldName, String value) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            String typename = field.getType().getSimpleName();
            field.set(object, "int".equals(typename) ? Integer.parseInt(value) : value);
            field.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
