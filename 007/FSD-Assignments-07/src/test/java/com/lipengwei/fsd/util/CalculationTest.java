package com.lipengwei.fsd.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculationTest {

    @Test
    public void add() {
        assertEquals(3, new Calculation().add(1, 2));
        assertEquals(0, new Calculation().add(-1, 1));
        assertEquals(-3, new Calculation().add(-1, -2));
    }

    @Test
    public void sub() {
        assertEquals(1, new Calculation().sub(2, 1));
        assertEquals(0, new Calculation().sub(2, 2));
        assertEquals(-1, new Calculation().sub(2, 3));
    }
}