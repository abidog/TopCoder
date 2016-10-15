public class MoveZeros {
    public int[] moveZeros(int[] arr) {
        int slow = 0,fast = 0;

        while (fast < arr.length) {
            if (arr[fast] == 0) {
                fast++;
                continue;
            }
            arr[slow] = arr[fast];
            slow++;
            fast++;
        }
        while (slow < arr.length) {
            arr[slow++] = 0;
        }
        return arr;
    }
}
