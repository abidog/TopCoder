public class LargeIntArray{
    int[] arr ;
    public LargeIntArray() {
        arr = new int[2];
    }
    public boolean increment() {
        int last = arr.length - 1;
        boolean carry = true;
        for (int k = last; k >= 0; k--) {
            int sum = arr[k] + (carry ? 1 : 0);
            carry = sum > 9;
            arr[k] = sum % 10;
            if (!carry) {
                break;
            }

        }
        if (carry) {
            // need to make a larger array and assign 1 to the head.
            return false;
        }
        return true;

    }
}
