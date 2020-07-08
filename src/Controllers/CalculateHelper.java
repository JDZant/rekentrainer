package Controllers;

import java.util.Random;

public class CalculateHelper {
    public CalculateHelper() {
    }

    public void generateNumbers3() {
        Random r = new Random();
        int low = 0;
        int high = 40;
        int result = r.nextInt(high - low) + low;
        System.out.println(result);
    }
}
