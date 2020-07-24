package com.ibm.lpw.app.report;

public class DeductionReport {

    private int year;
    private double startingSalary;
    private int numOfDeductions;
    private double deduction;
    private double incrementAmount;

    public DeductionReport(int year, double startingSalary, int numOfDeductions, double d,
            double incrementAmount) {
        super();
        this.year = year;
        this.startingSalary = startingSalary;
        this.numOfDeductions = numOfDeductions;
        this.deduction = d;
        this.incrementAmount = incrementAmount;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public double getStartingSalary() {
        return startingSalary;
    }
    public void setStartingSalary(double startingSalary) {
        this.startingSalary = startingSalary;
    }
    public int getNumOfDeductions() {
        return numOfDeductions;
    }
    public void setNumOfDeductions(int numOfDeductions) {
        this.numOfDeductions = numOfDeductions;
    }
    public double getDeduction() {
        return deduction;
    }
    public void setDeduction(int deduction) {
        this.deduction = deduction;
    }
    public double getIncrementAmount() {
        return incrementAmount;
    }
    public void setIncrementAmount(double incrementAmount) {
        this.incrementAmount = incrementAmount;
    }


}
