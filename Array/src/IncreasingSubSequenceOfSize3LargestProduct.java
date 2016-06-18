public class IncreasingSubSequenceOfSize3LargestProduct {
    public long maxProduct(long [] arrayLong) {

        long[] lsi = new long[arrayLong.length];
        long[] lgi = new long[arrayLong.length];
        long max = arrayLong[arrayLong.length - 1];
        for (int i = lgi.length - 2; i >= 0 ; i--) {

            if (arrayLong[i] > max) {
                lgi[i] = 0;
            } else {
                lgi[i] = max;
            }
            if (arrayLong[i] > max) {
                max = arrayLong[i];
            }

        }

        for (int i = 1; i < lsi.length ; i++) {
            max = 0;

            for (int p = 0; p < i; p++) {
                  if (arrayLong[p] < arrayLong[i] && arrayLong[p] > max) {
                      max = arrayLong[p];
                  }
            }
            lsi[i] = max;

        }
        max = 0;
        for (int i = 1; i < arrayLong.length - 1; i++) {
            max = Math.max(max, lsi[i] * arrayLong[i] * lgi[i]);
        }

        return max;
    }

}