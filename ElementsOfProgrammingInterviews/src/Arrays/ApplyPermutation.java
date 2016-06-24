package Arrays;

public class ApplyPermutation {
    public char[] apply(char[] arr, int[] perm) {
        if (arr == null || arr.length == 0 || perm == null || perm.length ==0) {
            return null;
        }

        for (int i = 0; i < arr.length; i++) {
            if (perm[i] >= 0) {
                char temp = arr[i];
                int a = i;

                do {
                    int nextA = perm[a];
                    char nextTemp = arr[nextA];
                    arr[nextA] = temp;
                    perm[a] = -perm.length;
                    temp = nextTemp;
                    a = nextA;

                } while (a != i);
            }
        }
        return arr;
    }
}

