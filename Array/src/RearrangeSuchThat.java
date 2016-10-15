public class RearrangeSuchThat {
    public void ranarrange(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            arr[i] += (arr[arr[i]] % n) * n;
            arr[i] /= n;
        }

    }
}
