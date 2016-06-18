public class BuySellStockProfit{

    public int oneProfit(int[] stockPrices) {
        if (stockPrices == null || stockPrices.length < 2) {
            return -1;
        }
        int min = stockPrices[0];
        int max =Integer.MIN_VALUE;
        for (int i : stockPrices) {
            max = Math.max(max, i - min);
            min =  Math.min(min, i);
        }
        return max;
    }
}

