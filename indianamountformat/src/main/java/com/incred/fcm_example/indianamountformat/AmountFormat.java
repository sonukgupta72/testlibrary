package com.incred.fcm_example.indianamountformat;

/**
 * Created by incredsonu on 14/12/17.
 */

public class AmountFormat {

    public static String formatIndianAmount(String amount) {
        if (isEmptyString(amount)) return "";

        amount = amount.replaceAll("[^0-9]", "");
        String reverseAmount = new StringBuffer(amount).reverse().toString();

        amount = "";
        boolean appendComma = false;
        int secondCount = 0;
        for (int i = 0; i < reverseAmount.length(); i++) {
            if (i > 2) {
                secondCount++;
            }

            if (appendComma) {
                amount = amount + "," + reverseAmount.charAt(i);
                appendComma = false;
            } else {
                amount = amount + reverseAmount.charAt(i);
            }
            if (i == 2) {
                appendComma = true;
            }
            if (secondCount == 2) {
                secondCount = 0;
                appendComma = true;
            }

        }
        amount = new StringBuffer(amount).reverse().toString();
        return amount;
    }

    public static boolean isEmptyString(String s) {
        return s == null || s.trim().length() <= 0;
    }
}
