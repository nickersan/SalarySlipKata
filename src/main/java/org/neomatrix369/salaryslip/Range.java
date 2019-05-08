package org.neomatrix369.salaryslip;

public class Range {

    private int lower;
    private int upper;

    public Range(int lower, int upper) {

        this.lower = lower;
        this.upper = upper;
    }

    public int apply(int value) {

        if (value > this.lower) {

            return (this.upper < value ? this.upper : value) - this.lower;
        }
        else {

            return 0;
        }
    }
}
