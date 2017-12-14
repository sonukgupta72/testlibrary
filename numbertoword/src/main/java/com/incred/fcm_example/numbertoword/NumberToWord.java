package com.incred.fcm_example.numbertoword;

import java.text.DecimalFormat;

/**
 * Created by sonu_incred on 6/7/17.
 */

public class NumberToWord {


    private static final String[] tensNames = {
            "",
            " Ten",
            " Twenty",
            " Thirty",
            " Forty",
            " Fifty",
            " Sixty",
            " Seventy",
            " Eighty",
            " Ninety"
    };
    private static final String[] numNames = {
            "",
            " One",
            " Two",
            " Three",
            " Four",
            " Five",
            " Six",
            " Seven",
            " Eight",
            " Nine",
            " Ten",
            " Eleven",
            " Twelve",
            " Thirteen",
            " Fourteen",
            " Fifteen",
            " Sixteen",
            " Seventeen",
            " Eighteen",
            " Nineteen"
    };

    public NumberToWord() {
    }

    private static String convertLessThanOneThousand(int number) {
        String soFar;

        if (number % 100 < 20) {
            soFar = numNames[number % 100];
            number /= 100;
        } else {
            soFar = numNames[number % 10];
            number /= 10;

            soFar = tensNames[number % 10] + soFar;
            number /= 10;
        }
        if (number == 0) return soFar;
        return numNames[number] + " Hundred" + soFar;
    }

    public static String convert(long number) {
        // 0 to 999 999 999 999
        if (number == 0) {
            return "zero";
        }

        String snumber = Long.toString(number);

        // pad with "0"
        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);

        // nxxnnnnnnnnn
        int arab = Integer.parseInt(snumber.substring(0, 3));
        // nnnXXnnnnnnn
        int crore = Integer.parseInt(snumber.substring(3, 5));
        // nnnnnXXnnnnn
        int lakh = Integer.parseInt(snumber.substring(5, 7));
        // nnnnnnnXXnnn
        int thousand = Integer.parseInt(snumber.substring(7, 9));
        // nnnnnnnnnXXX
        int hundred = Integer.parseInt(snumber.substring(9, 12));

        String tradArab;
        switch (arab) {
            case 0:
                tradArab = "";
                break;
            case 1:
                tradArab = convertLessThanOneThousand(arab)
                        + " Arab ";
                break;
            default:
                tradArab = convertLessThanOneThousand(arab)
                        + " Arab ";
        }
        String result = tradArab;

        String tradCrore;
        switch (crore) {
            case 0:
                tradCrore = "";
                break;
            case 1:
                tradCrore = convertLessThanOneThousand(crore)
                        + " Crore ";
                break;
            default:
                tradCrore = convertLessThanOneThousand(crore)
                        + " Crore ";
        }
        result = result + tradCrore;

        String tradLakh;
        switch (lakh) {
            case 0:
                tradLakh = "";
                break;
            case 1:
                tradLakh = convertLessThanOneThousand(lakh)
                        + " Lakh ";
                break;
            default:
                tradLakh = convertLessThanOneThousand(lakh)
                        + " Lakh ";
        }
        result = result + tradLakh;

        String tradHundredThousands;
        switch (thousand) {
            case 0:
                tradHundredThousands = "";
                break;
            case 1:
                tradHundredThousands = "One Thousand ";
                break;
            default:
                tradHundredThousands = convertLessThanOneThousand(thousand)
                        + " Thousand ";
        }
        result = result + tradHundredThousands;

        String tradThousand;
        tradThousand = convertLessThanOneThousand(hundred);
        result = result + tradThousand;

        // remove extra spaces!
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }

    public String getRupeeInWords(long num) {
        if (num < 1000) {
            return (convertLessThanOneThousand((int) num) + " Rupees").replaceAll("  ", " ");
        } else {
            return (convert(num) + " Rupees").replaceAll("  ", " ");
        }
    }

}
