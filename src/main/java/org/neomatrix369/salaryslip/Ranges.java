package org.neomatrix369.salaryslip;

public class Ranges {

    public static final Range INCOME_TAX_LOWER = new Range(
        11000,
        43000
    );

    public static final Range INCOME_TAX_HIGHER = new Range(
        43000,
        150000
    );

    public static final Range INCOME_TAX_TOP = new Range(
        150000,
        Integer.MAX_VALUE
    );

    public static final Range INCOME_TAX_PERSONAL_ALLOWANCE_EROSION = new Range(
        100000,
        122000
    );

    public static final Range NATIONAL_INSURANCE_LOWER = new Range(
        8060,
        43000
    );

    public static final Range NATIONAL_INSURANCE_TOP = new Range(
        43000,
        Integer.MAX_VALUE
    );
}
