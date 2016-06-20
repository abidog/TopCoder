public class MaxPrefix{
    public int maxPrefix(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int min = arr[arr.length - 1];
        int count = 0;
        int max = 0;
        int n = arr.length;
        for (int i = arr.length -2; i >= 0; i--) {
            if (arr[i] < min) {
                max = Math.max(max,  n - i -1);
                min = arr[i];
            }
        }
        return max;
    }

}