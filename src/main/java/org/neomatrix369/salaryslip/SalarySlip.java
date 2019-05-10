package org.neomatrix369.salaryslip;

public class SalarySlip {

    private static final int PRECISION = 2;

    private int employeeId;
    private String employeeName;
    private double salary;
    private double taxableIncome;
    private double incomeTax;
    private double nationalInsurance;

    public SalarySlip(int employeeId, String employeeName, double salary, double taxableIncome, double incomeTax, double nationalInsurance) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = round(salary);
        this.taxableIncome = round(taxableIncome);
        this.incomeTax = round(incomeTax);
        this.nationalInsurance = round(nationalInsurance);
    }

    public int getEmployeeId() {

        return this.employeeId;
    }

    public String getEmployeeName() {

        return this.employeeName;
    }

    public double getIncomeTax() {

        return this.incomeTax;
    }

    public double getNationalInsurance() {

        return this.nationalInsurance;
    }

    public double getSalary() {

        return this.salary;
    }

    public double getTaxableIncome() {

        return this.taxableIncome;
    }

    public double getTaxFreeAllowance() {

        return round(this.salary - this.taxableIncome);
    }

    private static double round (double value) {

        int scale = (int)Math.pow(10, PRECISION);
        return (double) Math.round(value * scale) / scale;
    }
}
