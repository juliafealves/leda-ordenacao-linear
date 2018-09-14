package sorting.linearSorting;

import sorting.AbstractSorting;
import util.Util;

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
            int max = Util.getMax(array, leftIndex, rightIndex);
            int gap = Util.getMin(array, leftIndex, rightIndex);
            int size = Math.abs(max) + Math.abs(gap);

            if (gap <= 0) {
                size += 1;
            }

            Integer[] cumulateSum = CountingSort.countNumber(size, gap, array, leftIndex, rightIndex);
            Util.getCumulativeSum(cumulateSum);

            CountingSort.sortPosition(array, leftIndex, rightIndex, gap, cumulateSum);
        }
    }
}
