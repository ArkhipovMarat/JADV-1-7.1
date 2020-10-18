public class CreditCalculator {
    final static int BASE_PERCENT = 2;
    final static int LOW_PERIOD = 12;
    final static int MIDDLE_PERIOD = 24;
    final static int HIGH_PERIOD = 36;
    final static int YEAR_PERCENT_FIX_RATE_LOW = 6;
    final static int YEAR_PERCENT_FIX_RATE_MIDDLE = 8;
    final static int YEAR_PERCENT_FIX_RATE_HIGH = 10;

    private double creditSumm;
    private double payTime;
    private double yearPercentRate;
    private double monthPercentRate;

    public CreditCalculator(double creditSumm, double payTime) {
        this.creditSumm = creditSumm;
        this.payTime = payTime;
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
    }

    public double payMonth() {
        double monthlyPayment = creditSumm * (monthPercentRate +
                (monthPercentRate / (Math.pow(1 + monthPercentRate, payTime) - 1)));

        return Math.round(monthlyPayment * 100) / 100D;
    }

    public double payAllSumm() {
        return payMonth() * payTime;
    }

    public double payAllPercentSumm() {
        return payMonth() * payTime - creditSumm;
    }
}