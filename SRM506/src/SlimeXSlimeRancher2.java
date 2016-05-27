
// Start 4:18pm
// end : 4:22pm
public class SlimeXSlimeRancher2 {

    public int train(int[] attributes) {
        int max = 0;
        for (int i : attributes) {
            max = Math.max(max, i);
        }
        int res =0;
        for (int i : attributes) {
            res += max - i;
        }
        return res;
    }

}
