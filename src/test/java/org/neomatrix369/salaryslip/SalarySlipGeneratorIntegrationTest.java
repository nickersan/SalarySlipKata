package org.neomatrix369.salaryslip;

import static org.junit.Assert.assertEquals;
import static org.neomatrix369.salaryslip.Deductions.INCOME_TAX;
import static org.neomatrix369.salaryslip.Deductions.NATIONAL_INSURANCE;

import org.junit.Test;

public class SalarySlipGeneratorIntegrationTest {

    private static final SalarySlipGenerator SALARY_SLIP_GENERATOR = new SalarySlipGenerator(INCOME_TAX, NATIONAL_INSURANCE);

    @Test
    public void testScenario1() {

        testScenario(
            24000,
            2000.00,
            1083.33,
            916.67,
            159.40,
            216.67
        );
    }

    @Test
    public void testScenario2() {

        testScenario(
            45000,
            3750.00,
            2833.33,
            916.67,
            352.73,
            600.00
        );
    }

    @Test
    public void testScenario3() {

        testScenario(
            101000,
            8416.67,
            7541.67,
            875.00,
            446.07,
            2483.33
        );
    }

    @Test
    public void testScenario4() {

        testScenario(
            122000,
            10166.67,
            10166.67,
            0,
            481.07,
            3533.33
        );
    }

    @Test
    public void testScenario5() {

        testScenario(
            151000,
            12583.33,
            12583.33,
            0,
            529.40,
            4504.17
        );
    }

    private void testScenario(
        int grossSalary,
        double salary,
        double taxableIncome,
        double taxFreeAllowance,
        double nationalInsurance,
        double incomeTax
    ) {
        int employeeId = 12345;
        String employeeName = "John J Doe";

        SalarySlip salarySlip = SALARY_SLIP_GENERATOR.generate(employeeId, employeeName, grossSalary);

        assertEquals(employeeId, salarySlip.getEmployeeId());
        assertEquals(employeeName, salarySlip.getEmployeeName());
        assertEquals(salary, salarySlip.getSalary(), 0);
        assertEquals(taxableIncome, salarySlip.getTaxableIncome(), 0);
        assertEquals(taxFreeAllowance, salarySlip.getTaxFreeAllowance(), 0);
        assertEquals(nationalInsurance, salarySlip.getNationalInsurance(), 0);
        assertEquals(incomeTax, salarySlip.getIncomeTax(), 0);
    }
}
