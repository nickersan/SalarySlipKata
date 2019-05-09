package org.neomatrix369.salaryslip;

public class RangeCalculations {

    public static final RangeCalculation INCOME_TAX_LOWER = new RangeCalculation(
        Ranges.INCOME_TAX_LOWER,
        0.2
    );

    public static final RangeCalculation INCOME_TAX_HIGHER = new RangeCalculation(
        Ranges.INCOME_TAX_HIGHER,
        0.4
    );

    public static final RangeCalculation INCOME_TAX_TOP = new RangeCalculation(
        Ranges.INCOME_TAX_TOP,
        0.45
    );

    public static final RangeCalculation INCOME_TAX_PERSONAL_ALLOWANCE_EROSION = new RangeCalculation(
        Ranges.INCOME_TAX_PERSONAL_ALLOWANCE_EROSION,
        (salary) -> (salary / 2) * 0.4
    );

    public static final RangeCalculation NATIONAL_INSURANCE_LOWER = new RangeCalculation(
        Ranges.NATIONAL_INSURANCE_LOWER, 
        0.12
    );

    public static final RangeCalculation NATIONAL_INSURANCE_TOP = new RangeCalculation(
        Ranges.NATIONAL_INSURANCE_TOP, 
        0.02
    );
}
