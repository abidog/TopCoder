public class RowAndManyCoins {

    public static void main(String[] args) {
    RowAndManyCoins row = new RowAndManyCoins();
        System.out.println(row.getWinner("BABABABA"));
    }

    public String getWinner(String cells) {

        cells = cells.replaceAll("(.)\\1+", "$1");
        int numA = 0;
        int numB = 0;
        for (int i = 0; i < cells.length(); i++) {
                if (cells.charAt(i) == 'A') {
                    numA++;
                } else {
                    numB++;
                }
        }
        if (numB > numA) {
            return "Bob";
        } else {
            return "Alice";
        }

    }
}
