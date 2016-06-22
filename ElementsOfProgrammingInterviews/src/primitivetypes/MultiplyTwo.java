package primitivetypes;

public class MultiplyTwo {

    public int multiply(int x, int y) {
        int sum = 0;
        while (x > 0) {
            if ((x & 0x1) == 1) {
                sum = add(sum, y);
            }

            x >>= 1;
            //  sum += 2^ky for every time x has 1 bit.
            y <<= 1;
        }
        return sum;
    }

    private int add(int a, int b) {
        // add the bits
        int k = 0;
        int total = 0;
        int ca = a;
        int cb = b;
        boolean carry = false;
        int index = 0;
        while (ca != 0 || cb != 0) {
            boolean ba = (ca & 0x1) == 1;
            boolean bb = (cb & 0x1) == 1;
            boolean sum = ba ^ bb ^ carry;
            carry = (ba & carry) || (bb & carry) || (ba & bb);
            total = setBit(total, index, sum);
            ca >>= 1;
            cb >>= 1;
            index++;
        }
        total = setBit(total, index, carry);
        return total;
    }

    private int setBit(int num, int i, boolean set) {
        if (set) {
            return num | (1 << i);
        }  else {
            return num & (~(1 << i));
        }
    }

}
