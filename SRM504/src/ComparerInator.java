public class ComparerInator {
    private int prog1(int a, int b) {
        return a;
    }
    private int prog2(int a, int b) {
        return b;
    }
    private int prog3(int a, int b) {
        return a < b ? a : b;
    }
    private int prog4(int a, int b) {
        return a < b ? b : a;
    }

    public static void main(String[] args) {
        ComparerInator ci = new ComparerInator();
        int[] A = {1,2,3,4,5,6,7,8,9,10,11};
        int[] B =  {5,4,7,8,3,1,1,2,3,4,6};
        int[] C =  {1,2,3,4,3,1,1,2,3,4,6};



        System.out.println(ci.makeProgram(A, B, C));
    }


    public int makeProgram(int[] A, int[] B, int[] wanted) {

        boolean p1 = true;
        boolean p2 = true;
        boolean p3 = true;
        boolean p4 = true;

        for (int i = 0; i < A.length; i++) {
            if (wanted[i]!=prog1(A[i], B[i])) {
                p1 = false;
            }
            if (wanted[i]!=prog2(A[i], B[i])) {
                p2 = false;
            }
            if (wanted[i]!=prog3(A[i], B[i])) {
                p3 = false;
            }
            if (wanted[i]!=prog4(A[i], B[i])) {
                p4 = false;
            }
        }

        if (p1 || p2) {
            return 1;
        }
        if (p3 || p4) {
            return 7;
        }
        return -1;

    }
}
