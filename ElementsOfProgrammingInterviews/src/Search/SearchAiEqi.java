package Search;

public class SearchAiEqi {
    public int search(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0;
        int h = arr.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (arr[m] >= m) {
                h = m;
            } else {
                l  = m + 1;
            }

        }
        return h;
    }
}
