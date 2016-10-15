package Search;

public class BinSearch {


    public int binSearch(int[] arr, int target) {
        if (arr == null) {
            return -1;
        }
        int l = 0;
        int h = arr.length - 1;
        while (l < h) {
            int m = l + (h - l) /2;
            if (arr[m] >= target) {
                h = m;
            } else{
                l = m + 1;
            }
        }
        if (arr[h] == target) {
            return h;
        }
        return -1;
    }

}
