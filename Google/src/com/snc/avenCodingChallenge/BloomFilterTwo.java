package com.snc.avenCodingChallenge;
import java.util.function.Function;
import java.util.List;
import java.util.Arrays;

public class BloomFilterTwo<T> {
    private final long[] points;
    private final int size;
    private final List<Function<T, Integer>> hashFunctions;

    BloomFilterTwo(final int size) {
        this.size = size;
        points = new long[(size + 63) >> 6];
        hashFunctions = Arrays.asList(multiplyWith(29), multiplyWith(19), multiplyWith(17));
    }

    private Function<T, Integer> multiplyWith(final int i) {
        return t -> (t.hashCode() * i) % size;
    }

    public void mark(int hash) {
        hash %= size;
        points[hash >> 6] |= (1 << (hash & 63));
    }

    public boolean isMarked(int hash) {
        hash %= size;
        return (points[hash >> 6] & (1 << (hash & 63))) != 0;
    }

    public void add(final T value) {
        hashFunctions.stream().map(function -> function.apply(value)).forEach(this::mark);
    }

    public boolean exists(final T value) {
        return hashFunctions.stream().map(function -> function.apply(value)).allMatch(this::isMarked);
    }
}
