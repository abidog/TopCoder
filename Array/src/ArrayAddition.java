public class ArrayAddition{
    // 1 9 8     1 2
// res : 2 1 9 _ 
    public int[] addArray(int[] intArray1, int[] intArray2) {
        int[] result = new int[Math.max(intArray1.length, intArray2.length) ];
        int i1 = intArray1.length - 1;
        int i2 = intArray2.length - 1;
        boolean carry = false;
        int res = result.length - 1;

        while (i1 >= 0 && i2 >= 0) {
            int sum = intArray1[i1] + intArray2[i2] + (carry ? 1 : 0);
            carry = sum > 9 ;
            result[res--] = sum % 10;
            i1--;
            i2--;
        }
        while (i1 >= 0) {
            int sum = intArray1[i1--] + (carry ? 1 : 0);
            carry = sum > 9;
            result[res--] = sum % 10;
        }
        while (i2 >= 0) {
            int sum = intArray2[i2--] + (carry ? 1 : 0);
            carry = sum > 9;
            result[res--] = sum % 10;
        }
        if (carry) {
            int[] result2 = new int[result.length + 1];
            result2[0] = 1;
            for (int i = 0; i < result.length; i++) {
                result2[i + 1] = result[i];
            }
            return result2;
        }

        return result;

    }
}