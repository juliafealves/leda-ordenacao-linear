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
        if(array.length > 0) {
            int size = this.getMax(array, leftIndex, rightIndex) + 1;
            int gap = this.getMin(array, leftIndex, rightIndex);

            Integer[] sum = this.countNumber(size, gap, array, leftIndex, rightIndex);
            this.cumulativeSum(sum);

            Integer[] helper = new Integer[array.length];
            System.arraycopy(array, 0, helper, 0, array.length);

            for (int i = rightIndex; i >= leftIndex; i--) {
                int number = helper[i];
                sum[number - gap] -= 1;
                int position = sum[number - gap];
                array[position] = number;
            }
        }
    }

    /**
     * Return the number greatest.
     *
     * @param array
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    private int getMax(Integer[] array, int leftIndex, int rightIndex) {
        int max = array[leftIndex];

        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        return max;
    }

    private int getMin(Integer[] array, int leftIndex, int rightIndex) {
        int min = array[leftIndex];

        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }

        return min;
    }

    private Integer[] countNumber(int size, int gap, Integer[] array, int leftIndex, int rightIndex) {
        Integer[] count = new Integer[size];

        for (int i = leftIndex; i <= rightIndex; i++) {
            int number = array[i];

            if (count[number - gap] == null) {
                count[number - gap] = 0;
            }

            count[number - gap] += 1;
        }
        return count;
    }

    private void cumulativeSum(Integer[] count) {
        for (int i = 1; i < count.length; i++) {
            if (count[i] == null) {
                count[i] = 0;
            }

            if (count[i - 1] == null) {
                count[i - 1] = 0;
            }

            count[i] = count[i] + count[i - 1];
        }
    }

}
