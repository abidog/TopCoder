package Arrays;

public class WinnableGame{
    public boolean isWin(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i <= max) {
                max = Math.max(max, i + arr[i]);
            }
        }
        if (max >= arr.length - 1) {
            return true;
        }  else {
            return false;
        }
    }
}

