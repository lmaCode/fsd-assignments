package com.ibm.lpw.app.utils;

import java.util.regex.Pattern;

public class ReportUtility {
    public static String numberToWordCompoundInterestConverter(int i) {
        switch(i) {
            case 1:
                return "Yearly";
            case 2:
                return "Half yearly";
            case 12:
                return "Monthly";
            default:
                return "Quarterly";
        }
        
    }
    
    public static int choiceToTrueValueIncrementConverter(int i) {
        switch(i) {
            case 1:
                return 12;
            case 2:
                return 4;
            case 3:
                return 2;
            default:
                return 1;
        }
    }
    
    public static int choiceToTrueValuePeriodConverter(int i) {
        switch(i) {
            case 1:
                return 5;
            case 2:
                return 10;
            case 3:
                return 20;
            default:
                return 30;
        }
    }

    public static boolean validInput(String input ) {
        return Pattern.matches("[1-9]\\d*|0", input);
    }
}
