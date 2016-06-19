public class KthSmallestinSortedTwoArray {

    public double findMedianSortedArrays(int[] a, int[] b) {

        int m = a.length;
        int n = b.length;

        if ((m + n) % 2 == 1) {
            return findKth(a,b, 0, m - 1, 0, n -1, (m + n) / 2);
        } else {
            return (findKth(a,b, 0, m - 1, 0, n -1, (m + n) / 2) + findKth(a,b, 0, m - 1, 0, n -1, ((m + n) / 2) - 1) ) * 0.5 ;
        }


    }

    public double findKth(int[] a, int[] b, int aStart, int aEnd, int bStart, int bEnd, int k) {
        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        if (aLen == 0) {
            return b[bStart + k];
        }
        if (bLen == 0) {
            return a[aStart + k];
        }

        if (k == 0) {
            return a[aStart] < b[bStart] ? a[aStart] : b[bStart];
        }

        int aMid = aLen * k / (aLen + bLen);
        int bMid = k - aMid - 1;

        aMid = aMid + aStart;
        bMid = bMid + bStart;

        if (a[aMid] > b[bMid]) {

            k = k - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k = k - (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;

        }
        return findKth(a, b, aStart, aEnd, bStart, bEnd, k);

    }
}
