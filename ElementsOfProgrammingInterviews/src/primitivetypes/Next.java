package primitivetypes;

public class Next{
    public int next(int num) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 31; i++) {
            if (((num >> i) & 0x1) == 1) {
                int right = rightZeroOfi(num, i);
                int left = leftZeroOfi(num, i);
                int difRight = (1 << i) - ( 1 << (right));
                int difLeft = ((1 << (left)) - (1 << i) );
                min = Math.min(min, Math.min(difRight, difLeft));
            }
        }
        return min;
    }
    private int rightZeroOfi(int num, int j) {
        for (int i = j -1; i  >= 0; i--) {
            if (((num >> i) & 0x1) == 0) {
                return i;
            }
        }
        return -1;
    }
    private int leftZeroOfi(int num, int j) {
        for (int i = j + 1; i < 31; i++ ) {
            if (((num >> i) & 0x1)  == 0) {
                return i;
            }
        }
        return -1;
    }
}



