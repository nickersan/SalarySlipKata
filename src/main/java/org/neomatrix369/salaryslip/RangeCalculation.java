package org.neomatrix369.salaryslip;

import java.util.function.Function;

public class RangeCalculation {

    private Range range;
    private Function<Integer, Double> calculation;

    public RangeCalculation(Range range, double rate) {

        this(range, (salary) -> salary * rate);
    }

    public RangeCalculation(Range range, Function<Integer, Double> calculation) {

        this.range = range;
        this.calculation = calculation;
    }

    public Double apply(int salary) {

        return this.calculation.apply(this.range.apply(salary));
    }
}
