public class CorrectMultiplicationTwo {

    public static void main(String[] args) {
        CorrectMultiplicationTwo cm = new CorrectMultiplicationTwo();
        System.out.println(cm.getMinimum(1000000, 1000000, 1000000));
    }

    public int getMinimum(int a, int b, int c) {

        long mn = 1000001;
        long res = Integer.MAX_VALUE;
        for (int i = 1; i <= mn ; i++) {
            for (int j = 1; j <= mn / i ; j++) {
                long k = i * j;
                res = Math.min(res, Math.abs(a - i)+ Math.abs(b - j) + Math.abs(c -k));

            }
        }

        return (int)res;

    }
}
