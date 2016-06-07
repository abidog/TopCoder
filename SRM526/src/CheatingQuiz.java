public class CheatingQuiz {

    public static void main(String[] args) {
        CheatingQuiz cq = new CheatingQuiz();
       cq.howMany("BACACABCBBBBCAAAAACCCABBCAA");
    }



    public 	int[] howMany(String answers) {
        int a = 0;
        int b = 0;
        int c = 0;
        for (char ch : answers.toCharArray()) {
            if (ch == 'A') {
                a++;
            } else if (ch == 'B') {
                b++;
            } else {
                c++;
            }
        }

        int[] res = new int[answers.length()];
        for (int i = 0; i < answers.length(); i++) {
            if (a > 0 && b > 0 && c > 0) {
                res[i] = 3;
            } else if ((a > 0 && b > 0) || (a > 0 && c > 0) || (c > 0 && b > 0) ) {
                res[i] = 2;
            } else {
                res[i] = 1;
            }
            if (answers.charAt(i)=='A') {
                a--;
            } else if (answers.charAt(i) == 'B') {
                b--;
            } else {
                c--;
            }
        }
        return  res;
    }
}
