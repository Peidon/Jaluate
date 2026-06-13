package org.xpd.type;

import org.xpd.errors.UnableReadFieldError;
import org.xpd.errors.ValueTypeCastError;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Value<T> {

    private final ValueType type;
    private final T value;
    private Map<String, Object> fields;

    public Value(T value) {
        if (value == null) {
            this.type = ValueType.Void;
            this.value = null;
            return;
        }

        this.value = value;
        var valueClass = value.getClass();

        if (valueClass.equals(Boolean.class)) {
            this.type = ValueType.Boolean;
            return;
        }

        if (valueClass.equals(Short.class) || valueClass.equals(Byte.class) ||
                valueClass.equals(Integer.class) ||
                valueClass.equals(Long.class) ||
                valueClass.equals(Float.class) ||
                valueClass.equals(Double.class) ||
                valueClass.equals(BigDecimal.class) ||
                valueClass.equals(BigInteger.class)
        ) {
            this.type = ValueType.Number;
            return;
        }

        if (valueClass.equals(Date.class) ||
                valueClass.equals(Time.class) ||
                valueClass.equals(Timestamp.class)) {
            this.type = ValueType.Time;
            return;
        }

        if (valueClass.equals(String.class)) {
            this.type = ValueType.String;
            return;
        }

        if (valueClass.isArray() || List.class.isAssignableFrom(valueClass)) {
            this.type = ValueType.Array;
            return;
        }

        var castMap = castToMap(value);
        if (!castMap.isEmpty()) {
            this.type = ValueType.Struct;
            this.fields = castToMap(value);
            return;
        }

        ValueType valueType = ValueType.Struct;
        try {
            this.fields = buildStruct(value);
        } catch (UnableReadFieldError e) {
            // todo log error

            valueType = ValueType.Undefined;
        } finally {
            this.type = valueType;
        }

    }

    private Map<String, Object> castToMap(Object obj) {
        Map<String, Object> result = new HashMap<>();

        if  (! (obj instanceof Map<?, ?> rawMap)) {
            return result;
        }

        for (Map.Entry<?, ?> entry : rawMap.entrySet()) {
            if (entry.getKey() instanceof String key) {
                result.put(key, entry.getValue());
            }
        }
        return result;
    }

    private Map<String, Object> buildStruct(Object obj) {
        Map<String, Object> fields = new HashMap<>();
        var cls = obj.getClass();
        while (cls != null && !cls.equals(Object.class)) {
            for (Field field : cls.getDeclaredFields()) {
                // skip static fields
                if (Modifier.isStatic(field.getModifiers())) {
                    continue;
                }

                boolean accessible = field.canAccess(obj);
                try {
                    field.setAccessible(true);
                    fields.put(field.getName(), field.get(obj));
                } catch (IllegalAccessException e) {
                    throw new UnableReadFieldError(field.getName(), obj);
                } finally {
                    field.setAccessible(accessible);
                }
            }
            cls = cls.getSuperclass();
        }

        return fields;
    }

    public Integer getInt() {
        return (Integer) value;
    }

    public Object[] getArray() {
        if (value != null && value.getClass().isArray()) {
            int length = Array.getLength(value);
            Object[] values = new Object[length];

            for (int i = 0; i < length; i++) {
                values[i] = Array.get(value, i);
            }

            return values;
        }

        if (value != null && List.class.isAssignableFrom(value.getClass())) {
            int length = ((List<?>) value).size();
            Object[] values = new Object[length];
            for (int i = 0; i < length; i++) {
                values[i] = ((List<?>) value).get(i);
            }

            return values;
        }
        
        throw new ValueTypeCastError(Object[].class.getName(), value);
    }

    public Map<String, ?> getStruct() {
        if (type == ValueType.Struct) {
            return this.fields;
        }
        throw new ValueTypeCastError(Map.class.getName(), value);
    }

    public T get() {
        return value;
    }

    public ValueType getType() {
        return type;
    }
}
