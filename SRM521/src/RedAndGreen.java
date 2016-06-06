// start : 2:05pm

public class RedAndGreen {
    public static void main(String[] args) {
        String row = "RGRGRGRGRGRGRGRGR";
        RedAndGreen red = new RedAndGreen();
        System.out.println(red.minPaints(row));
    }

    public int minPaints(String row) {
        int min = 53;
        for (int i = 0; i < row.length(); i++) {
            min = Math.min(min, countRed(row, i) + countGreen(row, i));

        }
        return min;
    }
    public int countRed(String row, int start) {
        int res = 0;
        for (int i = start + 1; i < row.length() ; i++) {
            if (row.charAt(i) == 'R') {
                res++;
            }
        }
        return res;
    }

    public int countGreen(String row, int end) {
        int res = 0;
        for (int i = 0; i < end ; i++) {
            if (row.charAt(i) == 'G') {
                res++;
            }
        }
        return res;
    }
}

