package util;

import java.util.Random;

public class SortUtil {

    public static int[] genRandomArray(int len, int maxNumber) {
        Random random = new Random();
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[i] = random.nextInt(maxNumber);
        }
        return ints;
    }
}
