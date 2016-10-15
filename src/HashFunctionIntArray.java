public class HashFunctionIntArray {
    public long hashCode(int[] freq) {
        int hash = freq.length;
        for (int i : freq) {
            hash = hash * 314159 + i;
        }
        return hash;
    }
}
