package banksystem.dao.utils;

public class LuhnAlgorithmUtil {

    public static int setAlgorithm(String pnr) {
        int extraChars = pnr.length() - 15;
        if (extraChars < 0) {
            throw new IllegalArgumentException("Number length must be at least 15 characters!");
        }
        pnr = pnr.substring(extraChars, 15 + extraChars);
        int sum = 0;
        for (int i = 0; i < pnr.length(); i++) {
            char tmp = pnr.charAt(i);
            int num = tmp - '0';
            int product;
            if (i % 2 != 0) {
                product = num;
            } else {
                product = num * 2;
            }
            if (product > 9)
                product -= 9;
            sum += product;
        }
        if (sum % 10 == 0) {
            return 0;
        } else {
            return (10 - (sum % 10));
        }
    }
}
