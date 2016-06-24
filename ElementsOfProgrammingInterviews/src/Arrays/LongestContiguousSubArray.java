package Arrays;

public class LongestContiguousSubArray{
    public int[] longest(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] minMax = new int[2];
        for (int start = 0; start < arr.length; ) {
            int runner = start;
            while (runner + 1 < arr.length && arr[runner] < arr[runner + 1]) {
                runner++;
            }
            if (runner - start > minMax[1] - minMax[0]) {
                minMax[0] = start;
                minMax[1] = runner;
            }
            start = runner + 1;
        }

        return minMax;
    }
}
