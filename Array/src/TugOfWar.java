public class TugOfWar {
    int min = Integer.MAX_VALUE;
    public int tugOfWar(int[] arr) {
        int sum = 0;

        for (int i : arr) {
            sum += i;
        }

        int max = arr.length / 2;
        partition(arr, 0, max, sum, 0);
        return min;

    }
    public void partition(int[] arr, int start, int n, int sum, int cur) {
        if (n == 0) {
            min = Math.min(min, Math.abs(Math.abs(sum - cur) - cur));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            partition(arr, start +1, n-1, sum, cur + arr[i]);
        }
    }
}
