package com.ibm.lpw.app.calculator;

public class Calculator {

	private double principal = 0.0;
	private double interest = 0;
	private int period = 0;
	private int compoundInterval = 0;
	private double interestDeduction = 0;
	private int compoundIntervalDeduction = 0;

	public double getInterestDeduction() {
		return interestDeduction;
	}

	public void setInterestDeduction(double interestDeduction) {
		this.interestDeduction = interestDeduction;
	}

	public int getCompoundIntervalDeduction() {
		return compoundIntervalDeduction;
	}

	public void setCompoundIntervalDeduction(int compoundIntervalDeduction) {
		this.compoundIntervalDeduction = compoundIntervalDeduction;
	}

	public Calculator(double principal, int interest, int period, int compoundInterval) {
		this.setPrincipal(principal);
		this.setInterest(interest);
		this.setPeriod(period);
		this.setCompoundInterval(compoundInterval);
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = calculateInterest(interest);
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getCompoundInterval() {
		return compoundInterval;
	}

	public void setCompoundInterval(int compoundInterval) {
		this.compoundInterval = compoundInterval;
	}

	public double getFutureValue() {
		return calculateCompoundInterest(this.period);
	}

	public double getStartingValue() {
		return calculateCompoundInterest(this.period - 1);
	}

	public double getYearlyReturn() {
		return (this.getFutureValue() - this.getStartingValue());
	}

	public double getDeductionRate() {
		return Double.valueOf(this.interest * this.compoundInterval * 100 * 100/ this.principal);
	}

	private double calculateCompoundInterest(int p) {
		double result = this.getPrincipal()
				* Math.pow((1 + (this.getInterest() / this.getCompoundInterval())), (this.getCompoundInterval() * p));
		return Double.valueOf(result);
	}

	private double calculateInterest(int interestInpercent) {
		return Double.valueOf(interestInpercent) / 100;
	}

}
