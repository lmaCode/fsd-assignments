package com.ibm.lpw.app;

import java.util.Scanner;

import com.ibm.lpw.app.report.ReportGenerator;
import com.ibm.lpw.app.utils.ReportUtility;

public class SalaryPredictor {

	public void generateReport() {

		renderBannerPage();
		Scanner sc = new Scanner(System.in);
		double salary = 0.0;

		do {
			System.out.print("Please enter the starting salary (not less than 1): ");
			String input = sc.next();
			while (!ReportUtility.validInput(input)) {
				System.out.printf("\"%s\" is not a valid number.Please provide your input again\n", input);
				input = sc.next();
			}
			salary = Double.parseDouble(input);
		} while (salary < 1);
		System.out.println();

		int incrementInterest = 0;
		do {
			System.out.print("Please enter the increment to be received (in percent): ");
			String input = sc.next();
			while (!ReportUtility.validInput(input)) {
				System.out.printf("\"%s\" is 1not a valid number.Please provide your input again\n", input);
				input = sc.next();
			}
			incrementInterest = Integer.parseInt(input);
		} while (incrementInterest < 0);

		System.out.println();
		int incrementFrequency = 0;
		do {
			System.out.print("Please select the frequency to be received: ");
			System.out.println();
			System.out.println("[1] Monthly");
			System.out.println("[2] Quarterly");
			System.out.println("[3] Half-yearly");
			System.out.println("[4] Yearly");
			System.out.println();
			System.out.println("Example: 1 for Monthly");
			String input = sc.next();
			while (!ReportUtility.validInput(input)) {
				System.out.printf("\"%s\" is not a valid number.Please provide your input again\n", input);
				input = sc.next();
			}
			incrementFrequency = Integer.parseInt(input);
		} while (incrementFrequency < 1 || incrementFrequency > 4);

		incrementFrequency = ReportUtility.choiceToTrueValueIncrementConverter(incrementFrequency);

		int deductionAmount = 0;
		do {
			System.out.print("Please enter the deduction amount(not less than 0): ");
			String input = sc.next();
			while (!ReportUtility.validInput(input)) {
				System.out.printf("\"%s\" is not a valid number.Please provide your input again\n", input);
				input = sc.next();
			}
			deductionAmount = Integer.parseInt(input);
		} while (deductionAmount < 0);

		System.out.println();

		/* frequency of deduction section */
		int deductionFrequency = 0;
		do {
			System.out.print("Please select the frequency the deductions done: ");
			System.out.println();
			System.out.println("[1] Monthly");
			System.out.println("[2] Quarterly");
			System.out.println("[3] Half-yearly");
			System.out.println("[4] Yearly");
			System.out.println();
			System.out.println("Example: 1 for Monthly");
			String input = sc.next();
			while (!ReportUtility.validInput(input)) {
				System.out.printf("\"%s\" is not a valid number.Please provide your input again\n", input);
				input = sc.next();
			}
			deductionFrequency = Integer.parseInt(input);
		} while (deductionFrequency < 0 || deductionFrequency > 4);

		deductionFrequency = ReportUtility.choiceToTrueValueIncrementConverter(deductionFrequency);

		/* period section */
		int period = 0;

		do {
			System.out.print("Please select the period of time");
			System.out.println();
			System.out.println("[1] 5 years");
			System.out.println("[2] 10 years");
			System.out.println("[3] 20 years");
			System.out.println("[4] 30 years");
			System.out.println();
			System.out.println("Example: 1 for 5 years");
			String input = sc.next();
			while (!ReportUtility.validInput(input)) {
				System.out.printf("\"%s\" is not a valid number.Please provide your input again\n", input);
				input = sc.next();
			}
			period = Integer.parseInt(input);
		} while (period < 0 || period > 4);

		period = ReportUtility.choiceToTrueValuePeriodConverter(period);

		sc.close();

		System.out.println();
		System.out.println();
		System.out.println();
		ReportGenerator.generate(salary, period, incrementInterest, incrementFrequency, deductionAmount,
				deductionFrequency);

	}

	private static void renderBannerPage() {
		System.out.println("                       _oo0oo_                      ");
		System.out.println("                      o8888888o                     ");
		System.out.println("                      88\" . \"88                     ");
		System.out.println("                      (| -_- |)                     ");
		System.out.println("                      0\\  =  /0                     ");
		System.out.println("                    ___/¡®---¡¯\\___                   ");
		System.out.println("                  .' \\|       |/ '.                 ");
		System.out.println("                 / \\\\|||  :  |||// \\                ");
		System.out.println("                / _||||| -…d-|||||_ \\               ");
		System.out.println("               |   | \\\\\\  -  /// |   |              ");
		System.out.println("               | \\_|  ''\\---/''  |_/ |              ");
		System.out.println("               \\  .-\\__  '-'  ___/-. /              ");
		System.out.println("             ___'. .'  /--.--\\  '. .'___            ");
		System.out.println("          .\"\" ¡®<  ¡®.___\\_<|>_/___.¡¯ >¡¯ \"\".          ");
		System.out.println("         | | :  ¡®- \\¡®.;¡®\\ _ /¡¯;.¡¯/ - ¡¯ : | |        ");
		System.out.println("         \\  \\ ¡®_.   \\_ __\\ /__ _/   .-¡¯ /  /        ");
		System.out.println("     =====¡®-.____¡®.___ \\_____/___.-¡¯___.-¡¯=====     ");
		System.out.println("                       ¡®=---=¡¯                      ");
		System.out.println("                                                    ");
		System.out.format("%84s", "|S|a|l|a|r|y|  |P|r|e|d|i|c|t|o|r|\n");
		System.out.println("******************* ******************************** ************* *****************\n");
		System.out.format("%84s", "Submitted By: Pengwei Li\n");
		System.out.format("%84s", "lpwei@cn.ibm.com\n\n");
		System.out.println(
				"******************* ******************************** ************* *****************\n\n\n\n");
	}

	public static void main(String[] args) {
		SalaryPredictor sIp = new SalaryPredictor();
		sIp.generateReport();
	}
}
