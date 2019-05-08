package org.neomatrix369.salaryslip;

import java.util.function.Function;
import java.util.stream.Stream;

public enum Deduction {

    INCOME_TAX(
        new Calculation(new Range(11000, 43000), 0.2),
        new Calculation(new Range(43000, 150000), 0.4),
        new Calculation(new Range(100000, 122000), (salary) -> (salary * 0.4) / 2),
        new Calculation(new Range(150000, Integer.MAX_VALUE), 0.45)
    ),

    NATIONAL_INSURANCE(
        new Calculation(new Range(8060, 43000), 0.12),
        new Calculation(new Range(43000, Integer.MAX_VALUE), 0.02)
    );

    private Calculation[] calculations;

    Deduction(Calculation... calculations) {

        this.calculations = calculations;
    }

    public double apply(int salary) {

        return Stream.of(calculations).mapToDouble((calculation) -> calculation.apply(salary)).sum();
    }

    private static class Calculation {

        private Range range;
        private Function<Integer, Double> calculation;

        Calculation(Range range, double rate) {

            this(range, (salary) -> salary * rate);
        }

        Calculation(Range range, Function<Integer, Double> calculation) {

            this.range = range;
            this.calculation = calculation;
        }

        Double apply(int salary) {

            return this.calculation.apply(this.range.apply(salary));
        }
    }
}
