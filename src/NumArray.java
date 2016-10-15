public class NumArray {

    public static void main(String[] args) {
        int[] arr = {-1};
        NumArray numArray = new NumArray(arr);
        System.out.println(numArray.sumRange(0, 0));
        //System.out.println(numArray.sumRange(2, 5));
        //
        // System.out.println(numArray.sumRange(0, 5));
    }

    int[] bit;
    public NumArray(int[] nums) {
        bit = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            updateVal(nums[i - 1], i);
        }
    }
    private void updateVal(int val, int index) {
        while (index < bit.length) {
            bit[index] += val;
            index = getNext(index);
        }
    }
    private int getSum(int index) {
        int sum = 0;
        index += 1;
        while (index > 0) {
            sum += bit[index];
            index = getParent(index);
        }
        return sum;
    }
    private int getParent(int i) {
        return i - (i & -i);
    }
    private int getNext(int i) {
        return i + (i & -i);
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return getSum(j);
        } else {
            return getSum(j) - getSum(i - 1);
        }
    }
}
