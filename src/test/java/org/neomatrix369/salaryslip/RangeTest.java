package org.neomatrix369.salaryslip;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RangeTest {

    @Test
    public void testUpperBoundAbove() {

        assertEquals(10, new Range(20, 30).apply(31));
    }

    @Test
    public void testUpperBoundAt() {

        assertEquals(10, new Range(20, 30).apply(30));
    }

    @Test
    public void testLowerBoundsAt() {

        assertEquals(0, new Range(20, 30).apply(20));
    }

    @Test
    public void testLowerBoundsBelow() {

        assertEquals(0, new Range(20, 30).apply(19));
    }

    @Test
    public void testWithinBounds() {

        assertEquals(1, new Range(20, 30).apply(21));
        assertEquals(9, new Range(20, 30).apply(29));
    }
}
