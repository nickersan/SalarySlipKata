package org.neomatrix369.salaryslip;

import static com.google.common.base.Preconditions.checkArgument;

class Range {

    private int lower;
    private int upper;

    Range(int lower, int upper) {

        checkArgument(lower >= 0, "Lower must be >= 0");
        checkArgument(upper >= lower, "Upper must be > lower");

        this.lower = lower;
        this.upper = upper;
    }

    int apply(int value) {

        if (value > this.lower) {

            return (this.upper < value ? this.upper : value) - this.lower;
        }
        else {

            return 0;
        }
    }
}
