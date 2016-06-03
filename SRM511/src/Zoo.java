public class Zoo {

    public static void main(String[] args) {
        Zoo z = new Zoo();
        int[] arr = {1,0,1};
        System.out.println(z.theCount(arr));
    }

    public long theCount(int[] answers) {

        int[] count = new int[41];

        for (int i : answers) {
            count[i]++;
        }
        for (int i = 0; i < answers.length; i++) {
            if (count[i] > 2) {
                return 0;
            }
            if (i < answers.length - 1) {
                if (count[i] < count[i + 1]) {
                    return 0;
                }
            }
        }

        int ln = 0;
        int sh = 0;
        long res = 1;
        for (int i = 0; i < answers.length; i++) {
            if (count[i] == 2) {
                res *= 2;
                sh++;
                ln++;
            } else if (count[i] == 1) {
                ln++;
            }
        }
        if (sh != ln) {
            res *= 2;
        }
        return res;

    }
}
