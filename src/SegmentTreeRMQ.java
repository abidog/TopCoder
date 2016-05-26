
public class SegmentTreeRMQ {

    int[] st;

    public SegmentTreeRMQ(int[] num) {
        int n = num.length;
        int h = (int) Math.ceil(Math.log(n)/ Math.log(2));
        int max = (int) (2 * Math.pow(2, h) - 1);
        st = new int[max];

        buildST(num, n - 1, 0, n - 1, 0);

    }

    private int rangeMinQuery(int n, int qs, int qe) {

        if (qs > qe || qs < 0 || qe > n) {
            return -1;
        }
        return rangeMinUtil(0, n, qs, qe, 0);
    }

    private int rangeMinUtil(int ss, int se, int qs, int qe, int cur) {

        if (qs > se || qe < ss) {
            return Integer.MAX_VALUE;
        }
        if (qs <= ss && se <= qe) {
            return st[cur];
        }
        int mid = ss + ((se - ss) >> 1);
        return Math.min(rangeMinUtil(ss, mid, qs, qe, 2 * cur + 1), rangeMinUtil(mid + 1, se, qs, qe, 2 * cur + 2));
    }


    private int buildST(int[] num, int n, int ss, int se,  int cur) {

        if (ss == se) {
            st[cur] = num[ss];
            return st[cur];
        }

        int mid = ss + ((se - ss) >> 1);

        st[cur] = Math.min(buildST(num, n, ss, mid, 2 * cur + 1), buildST(num, n, mid + 1, se, 2 * cur + 2));

        return st[cur];

    }

    public static void main(String args[])
    {
        int arr[] = {1, 3, 2, 7, 9, 11};
        int n = arr.length;
        SegmentTreeRMQ tree = new SegmentTreeRMQ(arr);

        int qs = 1;  // Starting index of query range
        int qe = 5;  // Ending index of query range

        // Print minimum value in arr[qs..qe]
        System.out.println("Minimum of values in range [" + qs + ", "
                + qe + "] is = " + tree.rangeMinQuery(n, qs, qe));
    }


}
