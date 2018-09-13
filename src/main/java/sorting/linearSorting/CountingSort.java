package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		int max = this.getMax(array, leftIndex, rightIndex);
		Integer[] sum = new Integer[max];

		for(int i = leftIndex; i <= rightIndex; i++) {
			int number = array[i];
			sum[number] += 1;
		}
	}

	/**
	 * Return the number greatest.
	 * @param array
	 * @param leftIndex
	 * @param rightIndex
	 * @return
	 */
	private int getMax(Integer[] array, int leftIndex, int rightIndex){
		int max = array[leftIndex];

		for (int i = leftIndex + 1; i <= rightIndex; i++){
			if (max < array[i]){
				max = array[i];
			}
		}

		return max;
	}

	public Integer[] countNumber(int size, Integer[] array, int leftIndex, int rightIndex){
		Integer[] count = new Integer[size];

		for(int i = leftIndex; i <= rightIndex; i++) {
			int number = array[i];
			count[number] += 1;
		}

		return count;
	}

}
