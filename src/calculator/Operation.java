package calculator;

public interface Operation {

    public boolean distinguish(String sign);

    public double execute(double x, double y) throws DividingException;
}
