public class MathContest {

    public static void main(String[] args) {
        MathContest mc = new MathContest();
        String bs = "W";
        int repe = 574;
        System.out.println(mc.countBlack(bs, repe));
    }

    public 	int countBlack(String ballSequence, int repetitions) {
        boolean negate = false;
        boolean reverse = false;
        int low = 0;
        int n = ballSequence.length();
        int high = ballSequence.length() * repetitions - 1;
        int res = 0;
        while (low <= high) {

            int next = (reverse ? high--: low++) % n;

            boolean black = ballSequence.charAt(next) == 'B';

            if (negate) {
                black = !black;
            }
            if (black) {
                negate = !negate;
                res++;
            } else {
                reverse = !reverse;
            }
        }
        return res;
    }

    public 	int countBlack2(String ballSequence, int repetitions) {
        StringBuilder first = new StringBuilder(ballSequence);
        StringBuilder seq = new StringBuilder(ballSequence);
        StringBuilder last = new StringBuilder("");
        repetitions--;
        if (repetitions > 0) {
            last = new StringBuilder(ballSequence);
            repetitions-=1;
        }
        int res = 0;
        int reverse = 0;
        int change = 0;
        while (repetitions > 0) {
            if (first.length() > 0) {
                char deleted = first.charAt(0);
                first = first.deleteCharAt(0);
                if (deleted == 'W') {
                    reverse++;
                    last = last.reverse();
                    StringBuilder  temp = first;
                    first = last;
                    last = temp.reverse();

                } else {
                    change++;
                    res++;
                    for (int i = 0; i < first.length(); i++) {

                        if (first.charAt(i)=='W') {
                            first.deleteCharAt(i);
                            first.insert(i, 'B');
                        } else {
                            first.deleteCharAt(i);
                            first.insert(i, 'W');
                        }
                    }
                    for (int i = 0; i < last.length(); i++) {

                        if (last.charAt(i)=='W') {
                            last = last.deleteCharAt(i);
                            last = last.insert(i, 'B');
                        } else {
                            last = last.deleteCharAt(i);
                            last = last.insert(i, 'W');
                        }
                    }
                }

            }

            if (first.length() == 0 && (repetitions > 0)){
                first = getFrom(reverse, change, seq);

                repetitions--;
            }
            if (last.length() == 0 && (repetitions > 0)){
                last = getFrom(reverse, change, seq);
                repetitions--;
            }

        }

        StringBuilder lastSimulation = first.append(last);
        while (lastSimulation.length() > 0) {
            char c = lastSimulation.charAt(0);
            lastSimulation.deleteCharAt(0);
            if (c == 'W') {
                 lastSimulation = lastSimulation.reverse();
            } else {
                res++;
                lastSimulation = change(lastSimulation);
            }

        }

        return res;
    }

    private StringBuilder change(StringBuilder str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'W') {
                str.deleteCharAt(i);
                str.insert(i, 'B');
            } else {
                str.deleteCharAt(i);
                str.insert(i, 'W');
            }
        }
        return str;
    }
    private StringBuilder getFrom(int reverse, int change, StringBuilder seq) {

        reverse %= 2;
        change %=2;
        StringBuilder first = new StringBuilder(seq);
        if (reverse == 1) {
            first = first.reverse();
        }
        if (change == 1) {
            for (int i = 0; i < first.length(); i++) {

                if (first.charAt(i)=='W') {
                    first = first.deleteCharAt(i);
                    first =first.insert(i, 'B');
                } else {
                    first = first.deleteCharAt(i);
                    first = first.insert(i, 'W');
                }
            }
        }
        return first;
    }
}
