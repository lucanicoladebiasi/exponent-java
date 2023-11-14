package com.github.lucanicoladebiasi.exponent;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KMessedArrayTest {

    @Test
    void sort() {
        List<Integer> input = Arrays.asList(1, 4, 5, 2, 3, 7, 8, 6, 10, 9);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        KMessedArray<Integer> actual = new KMessedArray<>(input).sort(2);
        assertEquals(expected, actual);
    }
}