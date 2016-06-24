package Arrays;

public class RotateArray{

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int[] rotateArray(int[] arr, int k) {
        k %= arr.length;
        int cycles = gcd(arr.length, k);
        for (int c = 0; c < cycles; c++) {
            int j = c;
            int temp = arr[c];
            while (true) {
                int next = j + k;
                if (next >= arr.length) {
                    next -= arr.length;
                }
                if (next == c) {
                    break;
                }
                arr[j] = arr[next];
                j = next;
            }
            arr[j] = temp;
        }
        return arr;
    }
}
