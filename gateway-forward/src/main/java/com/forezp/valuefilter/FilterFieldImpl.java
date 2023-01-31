package com.forezp.valuefilter;

import com.alibaba.fastjson.serializer.ValueFilter;

import java.lang.reflect.Field;

public class FilterFieldImpl implements ValueFilter {
    @Override
    public Object process(Object object, String name, Object value) {
        Class<?> objectClass = object.getClass();
        Field field = null;
        while (!objectClass.getName().equalsIgnoreCase("java.lang.object")) {
            try {
                field = objectClass.getDeclaredField(name);
                // 注意
                break;
            } catch (NoSuchFieldException e) {
                objectClass = objectClass.getSuperclass();
            }
        }
        if (field != null && field.getName().equals(name)) {
            if (field.isAnnotationPresent(FieldFilter.class)) {
                FieldFilter fieldFilter = field.getAnnotation(FieldFilter.class);
                String type = fieldFilter.type();
                return filterFieldValue(type, (String) value);
            }
        }
        return value;
    }

    private String filterFieldValue(String type, String value) {
        switch (type) {
            case "name":
                return filterName(value);
            case "address":
                return filterAddress(value);
        }
        return value;
    }

    private String filterAddress(String value) {
        // todo
        return value;
    }

    private String filterName(String value) {
        int length = value.length();
        StringBuffer sb = new StringBuffer(value);
        sb.replace(1, length > 2 ? length - 1 : 2, "*");
        return sb.toString();
    }
}
