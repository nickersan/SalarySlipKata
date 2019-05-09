package org.neomatrix369.salaryslip;

import static org.neomatrix369.salaryslip.RangeCalculations.INCOME_TAX_HIGHER;
import static org.neomatrix369.salaryslip.RangeCalculations.INCOME_TAX_LOWER;
import static org.neomatrix369.salaryslip.RangeCalculations.INCOME_TAX_PERSONAL_ALLOWANCE_EROSION;
import static org.neomatrix369.salaryslip.RangeCalculations.INCOME_TAX_TOP;
import static org.neomatrix369.salaryslip.RangeCalculations.NATIONAL_INSURANCE_LOWER;
import static org.neomatrix369.salaryslip.RangeCalculations.NATIONAL_INSURANCE_TOP;

public class Deductions {

    public static final Deduction INCOME_TAX = new Deduction(
        INCOME_TAX_LOWER,
        INCOME_TAX_HIGHER,
        INCOME_TAX_TOP,
        INCOME_TAX_PERSONAL_ALLOWANCE_EROSION
    );

    public static final Deduction NATIONAL_INSURANCE = new Deduction(
        NATIONAL_INSURANCE_LOWER,
        NATIONAL_INSURANCE_TOP
    );
}
