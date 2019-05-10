package org.neomatrix369.salaryslip;

public class SalarySlipGenerator {

    private static final double MONTHS_IN_YEAR = 12d;

    private Deduction incomeTaxDeduction;
    private Deduction nationalInsuranceDeduction;

    public SalarySlipGenerator(Deduction incomeTaxDeduction, Deduction nationalInsuranceDeduction) {

        this.incomeTaxDeduction = incomeTaxDeduction;
        this.nationalInsuranceDeduction = nationalInsuranceDeduction;
    }

    public SalarySlip generate(int employeeId, String employeeName, int salary) {

        return new SalarySlip(
            employeeId,
            employeeName,
            toMonthly(salary),
            toMonthly(this.incomeTaxDeduction.getAppliedTo(salary)),
            toMonthly(this.incomeTaxDeduction.apply(salary)),
            toMonthly(this.nationalInsuranceDeduction.apply(salary))
        );
    }

    private double toMonthly(int value) {

        return value / MONTHS_IN_YEAR;
    }

    private double toMonthly(double value) {

        return value / MONTHS_IN_YEAR;
    }
}
