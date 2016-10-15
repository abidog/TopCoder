public class MaxRepeatingNumber {
    public int maxRepeatingNumber(int [] arr, int k) {
        int len = arr.length;
        for (int i = 0; i < arr.length; i++) {
            arr[arr[i] % k] += k;
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
