package org.neomatrix369.salaryslip;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DeductionTest {

    @Test
    public void testApply() {

        int salary = 100;

        double result1 = 10;

        RangeCalculation rangeCalculation1 = createMock(RangeCalculation.class);
        expect(rangeCalculation1.apply(salary)).andReturn(result1);
        replay(rangeCalculation1);

        double result2 = 20;

        RangeCalculation rangeCalculation2 = createMock(RangeCalculation.class);
        expect(rangeCalculation2.apply(salary)).andReturn(result2);
        replay(rangeCalculation2);

        assertEquals(
            result1 + result2,
            new Deduction(rangeCalculation1, rangeCalculation2).apply(salary),
            0
        );

        verify(rangeCalculation1, rangeCalculation2);
    }
}
