package com.example.gdpprediction;

public class GDPRegression {
    private final double intercept;
    private final double slope;

    public GDPRegression(double[] years, double[] gdpGrowthRates) {
        if (years.length != gdpGrowthRates.length) {
            throw new IllegalArgumentException("Array lengths are not equal");
        }

        int n = years.length;

        // Compute slope and intercept
        double sumYears = 0.0;
        double sumGrowthRates = 0.0;
        for (int i = 0; i < n; i++) {
            sumYears += years[i];
            sumGrowthRates += gdpGrowthRates[i];
        }
        double meanYears = sumYears / n;
        double meanGrowthRates = sumGrowthRates / n;

        double numerator = 0.0;
        double denominator = 0.0;
        for (int i = 0; i < n; i++) {
            double deviationYears = years[i] - meanYears;
            double deviationGrowthRates = gdpGrowthRates[i] - meanGrowthRates;
            numerator += deviationYears * deviationGrowthRates;
            denominator += deviationYears * deviationYears;
        }
        slope = numerator / denominator;
        intercept = meanGrowthRates - slope * meanYears;
    }

    public double getIntercept() {
        return intercept;
    }

    public double getSlope() {
        return slope;
    }

    public double predict(double year) {
        return intercept + slope * year;
    }

    @Override
    public String toString() {
        return String.format("GDP Growth Rate = %.2f * Year + %.2f", slope, intercept);
    }

    public static void main(String[] args) {
        double[] years = {2019};
        double[] gdpGrowthRates = {0.1};

        GDPRegression regression = new GDPRegression(years, gdpGrowthRates);
        double predictedGrowth = regression.predict(2020);
        System.out.println("Predicted GDP Growth in Q4 2020: " + predictedGrowth);
    }
}
