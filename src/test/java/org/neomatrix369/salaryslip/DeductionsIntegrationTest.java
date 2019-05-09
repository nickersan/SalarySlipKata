package org.neomatrix369.salaryslip;

import static org.junit.Assert.assertEquals;
import static org.neomatrix369.salaryslip.Deductions.INCOME_TAX;
import static org.neomatrix369.salaryslip.Deductions.NATIONAL_INSURANCE;
import static org.neomatrix369.salaryslip.RangeCalculations.INCOME_TAX_HIGHER;
import static org.neomatrix369.salaryslip.RangeCalculations.INCOME_TAX_LOWER;
import static org.neomatrix369.salaryslip.RangeCalculations.INCOME_TAX_PERSONAL_ALLOWANCE_EROSION;
import static org.neomatrix369.salaryslip.RangeCalculations.INCOME_TAX_TOP;
import static org.neomatrix369.salaryslip.RangeCalculations.NATIONAL_INSURANCE_LOWER;
import static org.neomatrix369.salaryslip.RangeCalculations.NATIONAL_INSURANCE_TOP;

import java.util.stream.Stream;

import org.junit.Test;

public class DeductionsIntegrationTest {

    @Test
    public void testIncomeTaxBelowThreshold() {

        assertIncomeTax(11000);
    }

    @Test
    public void testIncomeTaxWithinLowerThreshold() {

        assertIncomeTax(11001, INCOME_TAX_LOWER);
        assertIncomeTax(43000, INCOME_TAX_LOWER);
    }

    @Test
    public void testIncomeTaxWithinHigherThreshold() {

        assertIncomeTax(43001, INCOME_TAX_LOWER, INCOME_TAX_HIGHER);
        assertIncomeTax(100000, INCOME_TAX_LOWER, INCOME_TAX_HIGHER);
        assertIncomeTax(150000, INCOME_TAX_LOWER, INCOME_TAX_HIGHER, INCOME_TAX_PERSONAL_ALLOWANCE_EROSION);
    }

    @Test
    public void testIncomeTaxWithPersonalAllowanceRemoved() {

        assertIncomeTax(100001, INCOME_TAX_LOWER, INCOME_TAX_HIGHER, INCOME_TAX_PERSONAL_ALLOWANCE_EROSION);
        assertIncomeTax(122000, INCOME_TAX_LOWER, INCOME_TAX_HIGHER, INCOME_TAX_PERSONAL_ALLOWANCE_EROSION);
    }

    @Test
    public void testIncomeTaxAboveTopThreshold() {

        assertIncomeTax(150001, INCOME_TAX_LOWER, INCOME_TAX_HIGHER, INCOME_TAX_TOP, INCOME_TAX_PERSONAL_ALLOWANCE_EROSION);
    }

    @Test
    public void testNationalInsuranceBelowThreshold() {

        assertNationalInsurance(8060);
    }

    @Test
    public void testNationalInsuranceWithinThreshold() {

        assertNationalInsurance(8061, NATIONAL_INSURANCE_LOWER);
        assertNationalInsurance(43000, NATIONAL_INSURANCE_LOWER);
    }

    @Test
    public void testNationalInsuranceAboveThreshold() {

        assertNationalInsurance(43001, NATIONAL_INSURANCE_LOWER, NATIONAL_INSURANCE_TOP);
    }

    private void assertIncomeTax(int salary, RangeCalculation... expectedRangeCalculations) {

        assertEquals(
            Stream.of(expectedRangeCalculations).mapToDouble((expectedRangeCalculation) -> expectedRangeCalculation.apply(salary)).sum(),
            INCOME_TAX.apply(salary),
            0
        );
    }

    private void assertNationalInsurance(int salary, RangeCalculation... expectedRangeCalculations) {

        assertEquals(
            Stream.of(expectedRangeCalculations).mapToDouble((expectedRangeCalculation) -> expectedRangeCalculation.apply(salary)).sum(),
            NATIONAL_INSURANCE.apply(salary),
            0
        );
    }
}
