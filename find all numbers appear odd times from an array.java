public static int[] allOdd(int[] array) {
    if (array.length < 2) {
        return array;
    }

    int[] sorted = array.clone();
    Arrays.sort(sorted);

    boolean odd = true;
    int len = 0;
    for (int i = 1; i < sorted.length; ++i) {
        if (sorted[i] == sorted[i - 1]) {
            odd = !odd;
        } else {
            if (odd) {
                sorted[len++] = sorted[i - 1];
            }
            odd = true;
        }
    }

    if (odd) {
        sorted[len++] = sorted[sorted.length - 1];
    }

    return Arrays.copyOf(sorted, len);
}