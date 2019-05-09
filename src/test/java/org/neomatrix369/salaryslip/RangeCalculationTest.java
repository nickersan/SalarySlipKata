package org.neomatrix369.salaryslip;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.util.function.Function;

import org.junit.Test;

public class RangeCalculationTest {

    @Test
    public void testWithRate() {

        assertEquals(5, new RangeCalculation(new Range(10, 20), 0.5).apply(20), 0);
    }

    @Test
    public void testWithCalculation() {

        int salary = 20;
        int salaryPart = 10;
        double expectedResult = 5;

        Range range = createMock(Range.class);
        expect(range.apply(salary)).andReturn(salaryPart);
        replay(range);

        Function<Integer, Double> calculation = createMock(Function.class);
        expect(calculation.apply(salaryPart)).andReturn(expectedResult);
        replay(calculation);

        assertEquals(expectedResult, new RangeCalculation(range, calculation).apply(salary), 0);

        verify(range, calculation);
    }
}
