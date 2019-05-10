package org.neomatrix369.salaryslip;

import static org.junit.Assert.assertEquals;
import static org.neomatrix369.salaryslip.Deductions.INCOME_TAX;
import static org.neomatrix369.salaryslip.Deductions.NATIONAL_INSURANCE;

import org.junit.Test;

public class SalarySlipGeneratorIntegrationTest {

    private static final SalarySlipGenerator SALARY_SLIP_GENERATOR = new SalarySlipGenerator(INCOME_TAX, NATIONAL_INSURANCE);

    @Test
    public void testScenario1() {

        SalarySlip salarySlip = SALARY_SLIP_GENERATOR.generate(12345, "John J Doe", 24000);
        assertEquals(2000.00, salarySlip.getSalary(), 0);
        assertEquals(1083.33, salarySlip.getTaxableIncome(), 0);
        assertEquals(916.67, salarySlip.getTaxFreeAllowance(), 0);
        assertEquals(159.40, salarySlip.getNationalInsurance(), 0);
        assertEquals(216.67, salarySlip.getIncomeTax(), 0);
    }
}
