public class MysteriousRestaurant {

    public static void main(String[] args) {
        MysteriousRestaurant ms = new MysteriousRestaurant();
        String[] prices = 	{"MnW1hd5FzcpY8RRmmgODVhT", "PKNlwgIX0311kd40agn8nEX", "Z0DvBjce6v1prf5Pf8Ohr1l", "pbQchBpEknSez9EdD9f21I8", "OyEmf5mOuLoV3zKHi7hM6oY", "i1iL4hdA3bOnESZdMvRrwRB", "B7HtTLhz3hfMjM0tPZFDohk", "R4dqtZH3lMKcnfHnjyS5hn3", "aCdqNPV6qZjgRJwU2Ioe6Tv", "rAuJEZ6HAHsycHTi51SmSjg", "wjwiL0BErK89WiFnqUem7vF", "nzGDjguPcdJKyKUD9mJIIzW", "3n0hZ5bpta36Jk1gKczfZH7", "mPt3hB1BEoAuOFVB65EBMwA", "2HmzuLH15gu9L3AVFwf9Ksc", "TzfgA1cK3t41nQImTweaFhi", "kvfP4xGfRFK7NMhhNZjOM7e", "9banBoTuYMXwQUC3tPOymig", "R5FASZI6grfS2TtuzFRtdw3", "hnS5mEnQdqdoIC4Nrv2JxTC", "qQRHK4BNlxqoj2Z7gQkSiwW", "5lP54KYGAzfQJibeRYSGFVp", "M9F4Zwz3zkS5pmd3xahLrPw", "UqTw4gPu1W7553481pa6eNh", "fIGMd7lXbcyWgfvYgSelXfq", "ggfEmHZSwpiJQp2yPcuvHZq", "pDGTxo9nSpQeafE2Z3kqUXt", "QwTKpksea5u10gAl6y9lYox", "YMyICQp3qkX9ZHzDp28r3mz", "otvyeRkZz6XFHy3ImnptK5s", "YsvehwQfkHagv2RSzV0FkwG", "3i3saNvStmLVTFu8yBhe5h3"};
        int budget = 2957;



        System.out.println(ms.maxDays(prices, budget));
    }

    public int maxDays(String[] prices, int budget) {

        int[][] price = new int[prices.length][prices[0].length()];

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < prices[0].length(); j++) {
                price[i][j] = prices[i].charAt(j) <= '9' ? prices[i].charAt(j) - '0' : prices[i].charAt(j) >= 'a' ? prices[i].charAt(j) - 61 : prices[i].charAt(j) - 55;
            }
        }
        int result = 0;
        for (int d = 1; d <= prices.length; d++) {
            int left = budget;
            if (isPossible(left, d, price)) {
                result = d;
            } else {
                break;
            }
        }

        return result;
    }
    // 24
    private boolean isPossible(int left, int d, int[][] price) {
        int spent = 0;
        // pick greedy cheapest dish
        if (d <= 7) {

            for (int i = 0; i < d; i++) {
                int min = price[i][0];
                for (int j = 0; j < price[0].length; j++) {
                    min = Math.min(min, price[i][j]);
                }
                spent+= min;
            }
        } else {

            int[][] newPrice = new int[7][price[0].length];
            int times = d/7;
            int nextDays = d % 7;
            int k = 0;
            while (times-- > 0) {
                for (int j = 0; j < 7; j++) {
                    for (int l = 0; l < price[0].length; l++) {
                            newPrice[j][l] += price[k][l];
                    }
                    k++;
                }
            }
            for (int i = 0; i < nextDays; i++) {
                for (int j = 0; j < price[0].length; j++) {
                    newPrice[i][j] += price[k][j];
                }
                k++;
            }
            for (int i = 0; i < 7; i++) {
                int min = newPrice[0][0];
                for (int j = 0; j < price[0].length; j++) {
                    min = Math.min(min, newPrice[i][j]);
                }
                spent+= min;
            }

        }

        return spent <= left;
    }
}
