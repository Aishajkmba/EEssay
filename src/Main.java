import com.example.gdpprediction.GDPRegression;

import java.util.Arrays;
import java.util.stream.IntStream;
public class Main {
    public static void main(String[] args) {
        double[] years = {2019};
        double[] gdpGrowthRates = {0.1};
        GDPRegression regression = new GDPRegression(years, gdpGrowthRates);
        double predictedGrowth = regression.predict(2020);
        System.out.println("Predicted GDP Growth in Q4 2020: " + predictedGrowth);
    }
    double[] actualGrowthRates = {0.1, 0.8};
    double[] timePeriods = {2019.75, 2020.75};

    GDPRegression regression = new GDPRegression(timePeriods, actualGrowthRates);

    double predictedGrowth = regression.predict(2021.75);
        System.out.println("Predicted GDP Growth in Q4 2021: " + predictedGrowth);
}
