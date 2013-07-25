package calculator;

public class Division implements Operation {

    public boolean distinguish(String sign) {
        return sign.equals("/");
    }

    public double execute(double x, double y) throws DividingException {
        if (y == 0) throw new DividingException("Dividing by 0"); 
        x = x / y;
        return x;
    }
}
