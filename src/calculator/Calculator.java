package calculator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;
import sun.awt.geom.Crossings;

public class Calculator {

    public static void main(String[] args) {
        /*
         * String pattern = "(\\d+)([\\+\\-\\*\\/])(\\d+)";
         * String[] a = s.split(pattern); //przypadek gdy chcemy zadeklarowac tablice: String[] equazion = new String[3];
         */
        //przechwycic wyjatek
        
        List<Operation> operations = new ArrayList<>(10);
        operations.add(new Addition());
        operations.add(new Subtration());
        operations.add(new Multiplication());
        operations.add(new Division());
        operations.add(new Power());
        String loop = "N";
        Scanner sreading = new Scanner(System.in);
        Scanner reading = new Scanner(System.in);
        Pattern p = Pattern.compile("(\\-?\\d+[\\.\\,]?[0-9]*)([\\/\\*\\-\\+\\^])(\\-?\\d+[\\.\\,]?[0-9]*)");
        while (loop.equals("N")) {
            String equazion = reading.nextLine(); //odczytanie rownania od uzytkownika
            equazion = equazion.replace(",", ".");
            Matcher m = p.matcher(equazion);
            if (m.find()) {
                double x = Double.parseDouble(m.group(1));
                double y = Double.parseDouble(m.group(3));
                String sign = m.group(2);
                Operation o = null;
                for (Operation operation : operations) {
                    if (operation.distinguish(sign)) {
                        o = operation;
                        break;
                    }
                }
                if (o != null) {
                    try {
                        System.out.println(o.execute(x, y));
                    } catch (DividingException t) {
                        System.out.println("Dividing by 0");
                    }
                } else {
                    System.out.println("Error");
                }
            }
            System.out.println("End? Y/N");
            try {
                loop = sreading.nextLine();
                loop = loop.toUpperCase();
            } catch (InputMismatchException r) {
                System.out.println("Write Y/N!");
                loop = "N";
            }
        }
    }
}
