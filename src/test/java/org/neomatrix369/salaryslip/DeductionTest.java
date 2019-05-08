package org.neomatrix369.salaryslip;

import static org.junit.Assert.assertEquals;
import static org.neomatrix369.salaryslip.Deduction.INCOME_TAX;
import static org.neomatrix369.salaryslip.Deduction.NATIONAL_INSURANCE;

import org.junit.Test;

public class DeductionTest {

    @Test
    public void testIncomeTaxBelowThreshold() {

        assertEquals(0, INCOME_TAX.apply(11000), 0);
    }

    @Test
    public void testIncomeTaxWithinLowerThreshold() {

        assertEquals(1 * 0.2, INCOME_TAX.apply(11001), 0);
        assertEquals((43000 - 11000) * 0.2, INCOME_TAX.apply(43000), 0);
    }

    @Test
    public void testIncomeTaxWithinHigherThreshold() {

        assertEquals(((43000 - 11000) * 0.2) + (1 * 0.4), INCOME_TAX.apply(43001), 0);
        assertEquals(((100000 - 43000) * 0.4) + ((43000 - 11000) * 0.2), INCOME_TAX.apply(100000), 0);
    }

    @Test
    public void testNationalInsuranceBelowThreshold() {

        assertEquals(0, NATIONAL_INSURANCE.apply(8060), 0);
    }

    @Test
    public void testNationalInsuranceWithinThreshold() {

        assertEquals(1 * 0.12, NATIONAL_INSURANCE.apply(8061), 0);
        assertEquals((43000 - 8060) * 0.12, NATIONAL_INSURANCE.apply(43000), 0);
    }

    @Test
    public void testNationalInsuranceAboveThreshold() {

        assertEquals(((43000 - 8060) * 0.12) + (1 * 0.02), NATIONAL_INSURANCE.apply(43001), 0);
    }
}
