package org.neomatrix369.salaryslip;

import java.util.function.Function;

public class RangeCalculation {

    private Range range;
    private Function<Integer, Double> calculation;

    private RangeCalculation(Range range, Function<Integer, Double> calculation) {

        this.range = range;
        this.calculation = calculation;
    }

    public int getAppliedTo(int salary) {

        return this.range.apply(salary);
    }

    public Double apply(int salary) {

        return this.calculation.apply(getAppliedTo(salary));
    }

    public static RangeCalculation custom(Range range, Function<Integer, Double> calculation) {

        return new RangeCalculation(range, calculation);
    }

    public static RangeCalculation percentage(Range range, int percentage) {

        return RangeCalculation.custom(range, (salary) -> salary * (((double)percentage) / 100));
    }
}
