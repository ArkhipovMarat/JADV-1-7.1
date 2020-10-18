import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class TDDCreditCalculator {
    final static int BASE_PERCENT = 2;
    final static int LOW_PERIOD = 12;
    final static int MIDDLE_PERIOD = 24;
    final static int HIGH_PERIOD = 36;
    final static int YEAR_PERCENT_FIX_RATE_LOW = 6;
    final static int YEAR_PERCENT_FIX_RATE_MIDDLE = 8;
    final static int YEAR_PERCENT_FIX_RATE_HIGH = 10;

    @Test
    public void testPayMonth() {
        double yearPercentRate;
        double monthPercentRate;

        Random random = new Random();
        double creditSumm = random.nextInt();
        double payTime = random.nextInt();

        CreditCalculator creditCalculator = new CreditCalculator(creditSumm,payTime);
        double calculatorMonthlyPayment = creditCalculator.payMonth();

        if (payTime <= LOW_PERIOD) {
            yearPercentRate = BASE_PERCENT + YEAR_PERCENT_FIX_RATE_HIGH;
        } else if (payTime <= MIDDLE_PERIOD) {
            yearPercentRate = BASE_PERCENT + YEAR_PERCENT_FIX_RATE_MIDDLE;
        } else if (payTime <= HIGH_PERIOD) {
            yearPercentRate = BASE_PERCENT + YEAR_PERCENT_FIX_RATE_LOW;
        } else {
            yearPercentRate = YEAR_PERCENT_FIX_RATE_LOW;
        }
        monthPercentRate = yearPercentRate / 100 / 12;

        double testMonthlyPayment = creditSumm * (monthPercentRate +
                (monthPercentRate / (Math.pow(1 + monthPercentRate, payTime) - 1)));

        testMonthlyPayment = Math.round(testMonthlyPayment * 100) / 100D;

        Assertions.assertEquals(testMonthlyPayment, calculatorMonthlyPayment);
    }

    @Test
    public void testPayAllSumm() {
        double yearPercentRate;
        double monthPercentRate;

        Random random = new Random();
        double creditSumm = random.nextInt();
        double payTime = random.nextInt();

        CreditCalculator creditCalculator = new CreditCalculator(creditSumm, payTime);
        double calculatorAllSummPayment = creditCalculator.payAllSumm();

        if (payTime <= LOW_PERIOD) {
            yearPercentRate = BASE_PERCENT + YEAR_PERCENT_FIX_RATE_HIGH;
        } else if (payTime <= MIDDLE_PERIOD) {
            yearPercentRate = BASE_PERCENT + YEAR_PERCENT_FIX_RATE_MIDDLE;
        } else if (payTime <= HIGH_PERIOD) {
            yearPercentRate = BASE_PERCENT + YEAR_PERCENT_FIX_RATE_LOW;
        } else {
            yearPercentRate = YEAR_PERCENT_FIX_RATE_LOW;
        }
        monthPercentRate = yearPercentRate / 100 / 12;

        double testMonthlyPayment = creditSumm * (monthPercentRate +
                (monthPercentRate / (Math.pow(1 + monthPercentRate, payTime) - 1)));

        testMonthlyPayment = Math.round(testMonthlyPayment * 100) / 100D;

        double testAllSummPayment = testMonthlyPayment * payTime;

        Assertions.assertEquals(testAllSummPayment, calculatorAllSummPayment);
    }

    @Test
    public void testPayAllPercentSumm() {
        double yearPercentRate;
        double monthPercentRate;

        Random random = new Random();
        double creditSumm = random.nextInt();
        double payTime = random.nextInt();

        CreditCalculator creditCalculator = new CreditCalculator(creditSumm, payTime);
        double calculatorAllPercentSummPayment = creditCalculator.payAllPercentSumm();

        if (payTime <= LOW_PERIOD) {
            yearPercentRate = BASE_PERCENT + YEAR_PERCENT_FIX_RATE_HIGH;
        } else if (payTime <= MIDDLE_PERIOD) {
            yearPercentRate = BASE_PERCENT + YEAR_PERCENT_FIX_RATE_MIDDLE;
        } else if (payTime <= HIGH_PERIOD) {
            yearPercentRate = BASE_PERCENT + YEAR_PERCENT_FIX_RATE_LOW;
        } else {
            yearPercentRate = YEAR_PERCENT_FIX_RATE_LOW;
        }
        monthPercentRate = yearPercentRate / 100 / 12;

        double testMonthlyPayment = creditSumm * (monthPercentRate +
                (monthPercentRate / (Math.pow(1 + monthPercentRate, payTime) - 1)));

        testMonthlyPayment = Math.round(testMonthlyPayment * 100) / 100D;

        double testAllSummPercentPayment = testMonthlyPayment * payTime-creditSumm;

        Assertions.assertEquals(testAllSummPercentPayment, calculatorAllPercentSummPayment);
    }
}