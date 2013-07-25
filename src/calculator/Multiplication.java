package calculator;

public class Multiplication implements Operation {

    public boolean distinguish(String sign) {
        return sign.equals("*");
    }

    public double execute(double x, double y) {
        x = x * y;
        return x;
    }
}
