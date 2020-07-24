package com.ibm.lpw.app.report;

public class IncrementReport {

    private int year;
    private double startingSalary;
    private int numOfIncrements;
    private int increment;
    private double incrementAmount;

    public IncrementReport(int year, double startingSalary, int numOfIncrements, int increment,
            double incrementAmount) {
        super();
        this.year = year;
        this.startingSalary = startingSalary;
        this.numOfIncrements = numOfIncrements;
        this.increment = increment;
        this.incrementAmount = incrementAmount;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public double getStartingSalary() {
        return this.startingSalary;
    }
    public void setStartingSalary(double startingSalary) {
        this.startingSalary = startingSalary;
    }
    public int getNumOfIncrements() {
        return numOfIncrements;
    }
    public void setNumOfIncrements(int numOfIncrements) {
        this.numOfIncrements = numOfIncrements;
    }
    public int getIncrement() {
        return increment;
    }
    public void setIncrement(int increment) {
        this.increment = increment;
    }
    public double getIncrementAmount() {
        return incrementAmount;
    }
    public void setIncrementAmount(double incrementAmount) {
        this.incrementAmount = incrementAmount;
    }

}
