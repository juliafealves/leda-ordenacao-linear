package sorting.linearSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 */
public class CountingSort extends AbstractSorting<Integer> {

    @Override
    public void sort(Integer[] array, int leftIndex, int rightIndex) {
        if (array.length > 0) {
            int size = Util.getMax(array, leftIndex, rightIndex);
            int gap = Util.getMin(array, leftIndex, rightIndex);

            if (gap == 0) {
                size += 1;
            }

            Integer[] sum = CountingSort.countNumber(size, gap, array, leftIndex, rightIndex);
            Util.getCumulativeSum(sum);
            sortPosition(array, leftIndex, rightIndex, gap, sum);
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
