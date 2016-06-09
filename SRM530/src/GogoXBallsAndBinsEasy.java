public class GogoXBallsAndBinsEasy {

    public static void main(String[] args) {
        GogoXBallsAndBinsEasy g = new GogoXBallsAndBinsEasy();
        int[] T = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(g.solve(T));
    }

    public int solve(int[] T) {
        int mx = 0;

        int l = 0;
        int r = T.length - 1;
        while (l < r) {
            mx += T[r--] - T[l++];
        }
        return mx;

    }
}
