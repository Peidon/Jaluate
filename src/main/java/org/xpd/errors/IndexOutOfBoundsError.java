package org.xpd.errors;

public class IndexOutOfBoundsError extends RuntimeException {
    public IndexOutOfBoundsError(int index, int size) {
        super(String.format("index out of bound error: index %d, array length %d", index, size));
    }
}
