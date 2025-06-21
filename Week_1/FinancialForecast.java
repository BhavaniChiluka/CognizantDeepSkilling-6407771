public class FinancialForecast {
    // Recursion
    public static double forecast(double p, double r, int t) {
        if (t == 0) {
            return p;
        }

        //grow the value by rate each year
        return forecast(p * (1 + r), r, t - 1);
    }

    public static void main(String[] args) {
        double principle = 1000.0; // say 1000 Rs
        double rate = 0.2;      // 20% annual growth
        int time = 5;                 // Predict for 5 years 

        double res = forecast(principle, rate, time);

        System.out.printf("after %d years the predicted amount is: %.2f Rs\n", time, res);
    }
}

//here we are using recursion to calculate the future value of an investment based on the principle amount, rate of growth, and time period. The function `forecast` recursively calculates the value by multiplying the current value by (1 + rate) for each year.
//but when the time is large, it will take a lot of time to calculate the value. So we can use iteration to calculate the value in a more efficient way.
// using iteration, the time complexity will reduce to O(n) from O(2^n) in recursion.