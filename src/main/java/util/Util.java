package util;

/**
 * Class containing useful methods for arrays manipulation.
 */
public class Util {

    /**
     * Swaps the contents of two positions in an array.
     *
     * @param array The array to be modified, not null
     * @param i     One of the target positions
     * @param j     The other target position
     */
    public static void swap(Object[] array, int i, int j) {
        if (array == null)
            throw new IllegalArgumentException();

        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * It says if a specific number is prime or not.
     *
     * @param n
     * @return
     */
    public static boolean isPrime(long n) {
        boolean result = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }


    /**
     * Return the greatest number in Integers' array.
     *
     * @author Julia Fernandes
     *
     * @param array
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    public static int getMax(Integer[] array, int leftIndex, int rightIndex) {
        int max = array[leftIndex];

        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        return max;
    }

    /**
     * Return the smallest number in Integers' array.
     *
     * @author Julia Fernandes
     *
     * @param array
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    public static int getMin(Integer[] array, int leftIndex, int rightIndex) {
        int min = array[leftIndex];

        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }

        return min;
    }

    /**
     * Generate an array with a cumulative sum.
     *
     * @author Julia Fernandes.
     *
     * @param array
     */
    public static void getCumulativeSum(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = 0;
            }

            if (array[i - 1] == null) {
                array[i - 1] = 0;
            }

            array[i] = array[i] + array[i - 1];
        }
    }
}