public class MinimumDistanceTwoNumber {
    public int minDistanceTwoNumber(int[] arr, int x, int y) {
        int lastX = -1;
        int lastY = -1;
        int min = (int)1e6;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                lastX = i;
                if (lastY != -1) {
                    min = Math.min(min, i - lastY);
                }
            }
            if (arr[i] == y) {
                lastY = i;
                if (lastX != -1) {
                    min = Math.min(min, i - lastX);
                }
            }
        }
        return min;
    }
}
