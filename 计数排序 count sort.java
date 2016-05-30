public class CountSort {

		public static void main(String[] args) throws Exception {
			int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 6, 1, 0 };

			System.out.println("Before sort:");
			ArrayUtils.printArray(array);

			countSort(array, 9);

			System.out.println("After sort:");
			ArrayUtils.printArray(array);
		}

		public static void countSort(int[] array, int range) throws Exception {
			if (range <= 0) {
				throw new Exception("range can't be negative or zero.");
			}

			if (array.length <= 1) {
				return;
			}

			int[] countArray = new int[range + 1];
			for (int i = 0; i < array.length; i++) {
				int value = array[i];
				if (value < 0 || value > range) {
					throw new Exception("array element overflow range.");
				}
				countArray[value] += 1;
			}

			for (int i = 1; i < countArray.length; i++) {
				countArray[i] += countArray[i - 1];
			}

			int[] temp = new int[array.length];
			for (int i = array.length - 1; i >= 0; i--) {
				int value = array[i];
				int position = countArray[value] - 1;

				temp[position] = value;
				countArray[value] -= 1;
			}

			for (int i = 0; i < array.length; i++) {
				array[i] = temp[i];
			}
		}
	}