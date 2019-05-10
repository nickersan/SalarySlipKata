package org.neomatrix369.salaryslip;

import java.util.function.Function;

public class RangeCalculation {

    private Range range;
    private Function<Integer, Integer> appliedTo;
    private Function<Integer, Double> calculation;

    private RangeCalculation(Range range, Function<Integer, Integer> appliedTo, Function<Integer, Double> calculation) {

        this.range = range;
        this.appliedTo = appliedTo;
        this.calculation = calculation;
    }

    public int getAppliedTo(int salary) {

        return this.appliedTo.apply(range.apply(salary));
    }

    public Double apply(int salary) {

        return this.calculation.apply(getAppliedTo(salary));
    }

    public static RangeCalculation custom(Range range, Function<Integer, Integer> appliedTo, Function<Integer, Double> calculation) {

        return new RangeCalculation(range, appliedTo, calculation);
    }

    public static RangeCalculation percentage(Range range, int percentage) {

        return RangeCalculation.custom(range, Function.identity(), (appliedTo) -> appliedTo * (((double)percentage) / 100));
    }
}
