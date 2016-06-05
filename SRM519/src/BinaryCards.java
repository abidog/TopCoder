public class BinaryCards {

    public static void main(String[] args) {
        BinaryCards bc = new BinaryCards();
        System.out.println(bc.largestNumber(1125899906842630l,1125899906842632l));
    }

    public long largestNumber(long A, long B) {

        for (int i = 60; i >= 0 ; i--) {
            // left most bit differed
            if ((((A ^ B) >> i) & 1) == 1 ) {
                return A | ((1l << (i + 1)) - 1);
            }

        }
        return A;

    }

}

