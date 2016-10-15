public class MultiplyAllFieldsExceptOwnPosition {
    public int[] multiplyAllFieldsExceptOwnPosition(int[] arr) {

        if (arr == null || arr.length == 0) {
            return null;
        }

        int[] output = new int[arr.length];

        int product = arr[0];
        for (int i = 1; i < arr.length ; i++) {
            output[i] = product;
            product *= arr[i];
        }
        product = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0 ; i--) {
            if (i == 0) {
                output[i] =  product;
            } else {
                output[i] *=  product;
            }

            product *= arr[i];
        }
        return output;
    }
}
