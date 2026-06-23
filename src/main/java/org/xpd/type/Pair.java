package org.xpd.type;

public class Pair {
    String Key;
    Object Value;
    public Pair(String key, Object value) {
        this.Key = key;
        this.Value = value;
    }
    public String getKey() {
        return Key;
    }
    public Object getValue() {
        return Value;
    }
}
