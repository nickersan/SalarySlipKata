package org.neomatrix369.salaryslip;

import static java.util.Arrays.asList;

import java.util.Collection;

public class Deduction {

    private Collection<RangeCalculation> calculations;

    public Deduction(RangeCalculation... calculations) {

        this.calculations = asList(calculations);
    }

    public int getAppliedTo(int salary) {

        return this.calculations.stream().mapToInt((calculation) -> calculation.getAppliedTo(salary)).sum();
    }

    public double apply(int salary) {

        return this.calculations.stream().mapToDouble((calculation) -> calculation.apply(salary)).sum();
    }
}
