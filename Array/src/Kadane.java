public class Kadane{
    class Triplet{
        int start;
        int end;
        int sum;
        public Triplet(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }

    public Triplet kadane(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int maxSoFar = 0;
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            maxSoFar += arr[i];
            if (maxSoFar < 0) {
                maxSoFar = 0;
                start = i + 1;
            }
            if (maxSoFar > max) {
                max = maxSoFar;
                end = i;
            }
        }

        return new Triplet(start, end, max);

    }

    public int wrapKadane(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        Triplet straightKadane = kadane(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            arr[i] = -arr[i];
        }
        Triplet wrapKadane = kadane(arr);
        if (straightKadane.sum < wrapKadane.sum + sum) {
            return wrapKadane.sum + sum;
        }
        return wrapKadane.sum;
    }

}