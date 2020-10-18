import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class TDDCreditCalculator {
    @Test
    public void testPayMonth() {
        double creditSumm = 1000000;
        double payTime = 36;
        double testSumm = 31336.37;

        CreditCalculator creditCalculator = new CreditCalculator(creditSumm, payTime);
        double calculatorMonthlyPayment = creditCalculator.payMonth();

        Assertions.assertEquals(testSumm, calculatorMonthlyPayment);
    }

    @Test
    public void testPayAllSumm() {
        double creditSumm = 1000000;
        double payTime = 36;
        double testSumm = 31336.37 * 36;

        CreditCalculator creditCalculator = new CreditCalculator(creditSumm, payTime);
        double calculatorAllSummPayment = creditCalculator.payAllSumm();

        Assertions.assertEquals(testSumm, calculatorAllSummPayment);
    }

    @Test
    public void testPayAllPercentSumm() {
        double creditSumm = 1000000;
        double payTime = 36;
        double testSumm = 31336.37 * 36 - creditSumm;

        CreditCalculator creditCalculator = new CreditCalculator(creditSumm, payTime);
        double calculatorAllPercentSummPayment = creditCalculator.payAllPercentSumm();

        Assertions.assertEquals(testSumm, calculatorAllPercentSummPayment);
    }
}