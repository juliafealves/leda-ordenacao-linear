package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

    @Override
    public void sort(Integer[] array, int leftIndex, int rightIndex) {
        if (array.length > 0) {
            int max = CountingSort.getMax(array, leftIndex, rightIndex);
            int min = CountingSort.getMin(array, leftIndex, rightIndex);
            int size = (max - min) + 1;

            Integer[] cumulateSum = CountingSort.countNumber(size, min, array, leftIndex, rightIndex);
            CountingSort.getCumulativeSum(cumulateSum);

            CountingSort.sortPosition(array, leftIndex, rightIndex, min, cumulateSum);
        }
    }
}
