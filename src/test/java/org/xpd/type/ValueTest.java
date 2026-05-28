package org.xpd.type;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class ValueTest {

    @Test
    public void constructorSetsVoidTypeForNull() {
        Value<Void> value = new Value<>(null);

        assertEquals(ValueType.Void, value.getType());
        assertNull(value.get());
    }

    @Test
    public void constructorSetsBooleanType() {
        Value<Boolean> value = new Value<>(Boolean.TRUE);

        assertEquals(ValueType.Boolean, value.getType());
        assertEquals(Boolean.TRUE, value.get());
    }

    @Test
    public void constructorSetsNumberType() {
        assertValueType(ValueType.Number, (byte) 1);
        assertValueType(ValueType.Number, (short) 2);
        assertValueType(ValueType.Number, 3);
        assertValueType(ValueType.Number, 4L);
        assertValueType(ValueType.Number, 5.0F);
        assertValueType(ValueType.Number, 6.0D);
        assertValueType(ValueType.Number, BigDecimal.TEN);
        assertValueType(ValueType.Number, BigInteger.TEN);
    }

    @Test
    public void constructorSetsTimeType() {
        assertValueType(ValueType.Time, Date.valueOf("2026-05-18"));
        assertValueType(ValueType.Time, Time.valueOf("10:15:30"));
        assertValueType(ValueType.Time, Timestamp.valueOf("2026-05-18 10:15:30"));
    }

    @Test
    public void constructorSetsStringType() {
        Value<String> value = new Value<>("hello");

        assertEquals(ValueType.String, value.getType());
        assertEquals("hello", value.get());
    }

    @Test
    public void constructorSetsArrayTypeAndKeepsOriginalArray() {
        int[] numbers = new int[]{1, 2, 3};
        Value<int[]> value = new Value<>(numbers);

        assertEquals(ValueType.Array, value.getType());
        assertSame(numbers, value.get());
        assertArrayEquals(numbers, value.get());
    }

    @Test
    public void getArrayReturnsObjectArrayFromPrimitiveArray() {
        Value<int[]> value = new Value<>(new int[]{1, 2, 3});

        assertArrayEquals(new Object[]{1, 2, 3}, value.getArray());
    }

    @Test
    public void getArrayReturnsObjectArrayFromObjectArray() {
        Value<String[]> value = new Value<>(new String[]{"a", "b"});

        assertArrayEquals(new Object[]{"a", "b"}, value.getArray());
    }

    @Test
    public void getArrayReturnsObjectArrayFromPrimitiveList() {
        Value<List<String>> value = new Value<>(Arrays.asList("a", "b"));
        assertArrayEquals(new Object[]{"a", "b"}, value.getArray());
    }

    @Test
    public void constructorSetsStructTypeAndStoresObjectFieldsByName() {
        ChildStruct struct = new ChildStruct();
        Value<ChildStruct> value = new Value<>(struct);

        assertEquals(ValueType.Struct, value.getType());

        Map<?, ?> fields = value.getStruct();
        Assert.assertNotNull(fields);
        assertEquals("Ada", fields.get("name"));
        assertEquals(42, fields.get("score"));
        assertEquals(true, fields.get("active"));
        assertFalse(fields.containsKey("STATIC_FIELD"));
    }

    @Test
    public void constructorSetsStructTypeAndKeepsStringKeyMap() {
        Map<String, Object> map = Map.of("name", "Ada", "score", 42);
        Value<Map<String, Object>> value = new Value<>(map);

        assertEquals(ValueType.Struct, value.getType());
        assertSame(map, value.get());
        assertSame(map, value.getStruct());
    }

    private void assertValueType(ValueType expected, Object object) {
        Value<Object> value = new Value<>(object);

        assertEquals(expected, value.getType());
        assertSame(object, value.get());
    }

    private static class ParentStruct {
        private final int score = 42;
    }

    private static class ChildStruct extends ParentStruct {
        private static final String STATIC_FIELD = "ignored";

        private final String name = "Ada";
        public final boolean active = true;
    }
}
