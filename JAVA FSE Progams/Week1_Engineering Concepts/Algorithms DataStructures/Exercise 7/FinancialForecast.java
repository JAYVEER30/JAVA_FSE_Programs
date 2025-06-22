public class FinancialForecast {

    public static double futureValue(double initialValue, double[] growthRates, int n) {
        if (n == 0) return initialValue;
        return futureValue(initialValue, growthRates, n - 1) * (1 + growthRates[n - 1]);
    }

    public static double futureValueIterative(double initialValue, double[] growthRates) {
        double value = initialValue;
        for (double rate : growthRates) {
            value *= (1 + rate);
        }
        return value;
    }

    public static void main(String[] args) {
        double initialValue = 1000.0;
        double[] growthRates = {0.05, 0.03, 0.04, 0.06};

        double predictedRecursive = futureValue(initialValue, growthRates, growthRates.length);
        double predictedIterative = futureValueIterative(initialValue, growthRates);

        System.out.println("Financial Forecasting Tool");
        System.out.printf("Initial Value: $%.2f\n", initialValue);
        System.out.print("Growth Rates: ");
        for (double rate : growthRates) System.out.printf("%.2f%% ", rate * 100);
        System.out.println();

        System.out.printf("Predicted Value (Recursive): $%.2f\n", predictedRecursive);
        System.out.printf("Predicted Value (Iterative): $%.2f\n", predictedIterative);
    }
}
