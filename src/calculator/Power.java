package calculator;

public class Power implements Operation {

    public boolean distinguish(String sign) {
        return sign.equals("^");
    }

    public double execute(double x, double y) {
        double result = x;
        for (int i = 2; i <= y; i++) {
            result = result * x;
        }
        return result;
    }
}
