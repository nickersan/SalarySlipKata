package org.neomatrix369.salaryslip;

public enum Deduction {

    INCOME_TAX(
        new Calculation(new Range(11000, 430000), 0.2),
        new Calculation(new Range(43000, 150000), 0.4),
        new Calculation(new Range(150000, Integer.MAX_VALUE), 0.45)
    ),

    NATIONAL_INSURANCE(
        new Calculation(new Range(8060, 43000), 0.12),
        new Calculation(new Range(43000, Integer.MAX_VALUE), 0.02)
    );

    private Deduction(Calculation... calculations) {

    }

    private static class Calculation {

        private Range range;
        private double rate;

        Calculation(Range range, double rate) {

            this.range = range;
            this.rate = rate;
        }

        public double apply(int salary) {

            return this.range.apply(salary) * this.rate;
        }
    }
}