package org.neomatrix369.salaryslip;

public class Deductions {

    public static final Deduction INCOME_TAX = new Deduction(
        new RangeCalculation(new Range(11000, 43000), 0.2),
        new RangeCalculation(new Range(43000, 150000), 0.4),
        new RangeCalculation(new Range(100000, 122000), (salary) -> (salary * 0.4) / 2),
        new RangeCalculation(new Range(150000, Integer.MAX_VALUE), 0.45)
    );

    public static final Deduction NATIONAL_INSURANCE = new Deduction(
        new RangeCalculation(new Range(8060, 43000), 0.12),
        new RangeCalculation(new Range(43000, Integer.MAX_VALUE), 0.02)
    );
}
