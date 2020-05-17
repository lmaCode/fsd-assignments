package com.ibm.lpw.app.report;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.ibm.lpw.app.calculator.Calculator;

public class ReportGenerator {
	public static void generate(double principal, int t, int interestInpercent, int n, int deductionAmount,
			int m) {
		DecimalFormat df = new DecimalFormat("#.##");
		List<IncrementReport> listOfIreport = new ArrayList<>();
		List<DeductionReport> listOfDreport = new ArrayList<>();
		List<Calculator> calculatorList = new ArrayList<>();

		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("RESULTS:");
		System.out.println("-------------------------------------------------------------------------------------\n\n");

		System.out.println("INCREMENT REPORT");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.format("%7s %17s %23s %17s %17s", "Year", "Starting Salary", "Number of increments", "Increment %",
				"Increment Amount");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------");
		for (int i = 1; i <= t; i++) {
			Calculator cIc = new Calculator(principal, interestInpercent, i, n);
			calculatorList.add(cIc);			
			IncrementReport iReport = new IncrementReport(i, cIc.getStartingValue(), n, interestInpercent,
					cIc.getYearlyReturn());
			listOfIreport.add(iReport);
			System.out.format("%7s %17s %23s %17s %17s", iReport.getYear(), df.format(iReport.getStartingSalary()),
					n, iReport.getIncrement(),
					df.format(iReport.getIncrementAmount()));
			System.out.println();
		}

		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("DEDUCTION REPORT");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.format("%7s %17s %23s %17s %17s", "Year", "Starting Salary", "Number of deductions", "Deduction %",
				"Deduction Amount");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------");

		listOfIreport.stream().forEachOrdered(iReport -> {
			Calculator cIc = new Calculator(iReport.getStartingSalary(), deductionAmount, iReport.getYear(),
					m);
			DeductionReport dReport = new DeductionReport(iReport.getYear(), iReport.getStartingSalary(), m,
					cIc.getDeductionRate(), deductionAmount*m);
			listOfDreport.add(dReport);
			System.out.format("%7s %17s %23s %17s %17s", dReport.getYear(), df.format(iReport.getStartingSalary()),
					m, df.format(dReport.getDeduction()),
					df.format(dReport.getIncrementAmount()));
			System.out.println();
		});

		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("PREDICTION REPORT");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.format("%7s %17s %23s %17s %17s", "Year", "Starting Salary", "Increment Amount", "Decrement Amount",
				"Salary Growth");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------");
		listOfIreport.stream().forEachOrdered(iReport -> {
			DeductionReport dReport = listOfDreport.get(iReport.getYear()-1);
			System.out.format("%7s %17s %23s %17s %17s", iReport.getYear(), df.format(iReport.getStartingSalary()),
					df.format(iReport.getIncrementAmount()), df.format(dReport.getIncrementAmount()),
					df.format(iReport.getIncrementAmount() - dReport.getIncrementAmount()));
			System.out.println();
		});
		System.out.println("-------------------------------------------------------------------------------------");
	}

}
