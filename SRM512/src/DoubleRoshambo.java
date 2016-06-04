public class DoubleRoshambo {
    // not complete
    public int maxScore(String[] A, String[] E) {
        long max = 1 << 50;
        return getPoint("AE","ED");

    }


    public int getPoint(String a, String e) {
        char p1L = a.charAt(0);
        char p1R = a.charAt(1);

        char p2L = e.charAt(0);
        char p2R = e.charAt(1);

        if ((p1R == 'R' && p2R == 'S') || (p1R == 'S' && p2R == 'P') || (p1R == 'P' && p2R == 'R') &&
                (p1L == 'R' && p2L == 'S') || (p1L == 'S' && p2L == 'P') || (p1L == 'P' && p2L == 'R')) {
            return 2;
        } else if ((p1R == 'R' && p2R == 'S') || (p1R == 'S' && p2R == 'P') || (p1R == 'P' && p2R == 'R') &&
        (p1L == 'R' && p2L == 'R') || (p1L == 'S' && p2L == 'S') || (p1L == 'P' && p2L == 'P')) {
            return 1;
        } else {
            return 0;
        }

    }
}
