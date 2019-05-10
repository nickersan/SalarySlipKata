package org.neomatrix369.salaryslip;

public class RangeCalculations {

    public static final RangeCalculation INCOME_TAX_LOWER = RangeCalculation.percentage(
        Ranges.INCOME_TAX_LOWER,
        20
    );

    public static final RangeCalculation INCOME_TAX_HIGHER = RangeCalculation.percentage(
        Ranges.INCOME_TAX_HIGHER,
        40
    );

    public static final RangeCalculation INCOME_TAX_TOP = RangeCalculation.percentage(
        Ranges.INCOME_TAX_TOP,
        45
    );

    public static final RangeCalculation INCOME_TAX_PERSONAL_ALLOWANCE_EROSION = RangeCalculation.custom(
        Ranges.INCOME_TAX_PERSONAL_ALLOWANCE_EROSION,
        (salary) -> (salary / 2) * 0.4
    );

    public static final RangeCalculation NATIONAL_INSURANCE_LOWER = RangeCalculation.percentage(
        Ranges.NATIONAL_INSURANCE_LOWER, 
        12
    );

    public static final RangeCalculation NATIONAL_INSURANCE_TOP = RangeCalculation.percentage(
        Ranges.NATIONAL_INSURANCE_TOP, 
        2
    );
}
