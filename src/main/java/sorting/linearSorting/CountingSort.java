package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 */
public class CountingSort extends AbstractSorting<Integer> {

    @Override
    public void sort(Integer[] array, int leftIndex, int rightIndex) {
        if (array.length > 0) {
            int size = CountingSort.getMax(array, leftIndex, rightIndex);
            int gap = CountingSort.getMin(array, leftIndex, rightIndex);

            if (gap == 0) {
                size += 1;
            }

            Integer[] sum = CountingSort.countNumber(size, gap, array, leftIndex, rightIndex);
            CountingSort.getCumulativeSum(sum);
            sortPosition(array, leftIndex, rightIndex, gap, sum);
        }
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
    static int getMax(Integer[] array, int leftIndex, int rightIndex) {
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
    static int getMin(Integer[] array, int leftIndex, int rightIndex) {
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
    static void getCumulativeSum(Integer[] array) {
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

    /**
     * Sort position the numbers in array.
     * @param array
     * @param leftIndex
     * @param rightIndex
     * @param gap
     * @param sum
     */
    static void sortPosition(Integer[] array, int leftIndex, int rightIndex, int gap, Integer[] sum) {
        Integer[] helper = new Integer[array.length];
        System.arraycopy(array, 0, helper, 0, array.length);

        for (int i = rightIndex; i >= leftIndex; i--) {
            int number = helper[i];
            int j = number - gap;
            sum[j] -= 1;
            int position = sum[j] + leftIndex;
            array[position] = number;
        }
    }

    /**
     * Counts the amount of occurrence of an integer number in the array.
     *
     * @param size
     * @param gap
     * @param array
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    static Integer[] countNumber(int size, int gap, Integer[] array, int leftIndex, int rightIndex) {
        Integer[] count = new Integer[size];

        for (int i = leftIndex; i <= rightIndex; i++) {
            int number = array[i];
            int position = number - gap;

            if (count[position] == null) {
                count[position] = 0;
            }

            count[position] += 1;
        }
        return count;
    }
}
