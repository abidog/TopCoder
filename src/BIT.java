
public class BIT {
    public int[] createBIT(int[] input) {
        int[] bit = new int[input.length + 1];
        for (int i = 1; i <= input.length; i++) {
            updateValue(bit, input[i - 1], i);
        }
        return bit;
    }
    private void updateValue(int[] bit, int val, int index) {
        while(index <= bit.length) {
            bit[index] += val;
            index = getNext(index);
        }
    }
    public int getSum(int[] bit, int index) {
        index += 1;
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index = getParent(index);
        }
        return sum;
    }

    public int getNext(int i) {
        return i + (i & -i);
    }

    public int getParent(int i) {
        return i - (i & -i);
    }
}
