// Start 10:10am
// end  10:16am

import java.util.PriorityQueue;

public class TheJackpotDivTwo {

    public static void main(String[] args) {
        TheJackpotDivTwo jackpot = new TheJackpotDivTwo();
        int[] money =  {21, 85, 6, 54, 70, 100, 91, 60, 71};
        int pot = 15;
        int[] res = jackpot.find(money, pot);
        for (int i = 0; i < money.length; i++) {
            System.out.println(res[i]+" ");
        }

    }

    public int[] find(int[] money, int jackpot) {

        PriorityQueue minHeap = new PriorityQueue<Integer>();
        for (int i = 0; i < money.length; i++) {
            minHeap.add(money[i]);
        }
        while (jackpot-- > 0) {
            int num = (int)minHeap.poll();
            num++;
            minHeap.add(num);

        }
        for (int i = 0; i < money.length; i++) {
            money[i] = (int)minHeap.poll();
        }
        return money;
    }
}
