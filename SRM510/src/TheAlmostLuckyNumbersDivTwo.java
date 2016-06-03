public class TheAlmostLuckyNumbersDivTwo {

    public static void main(String[] args) {
        TheAlmostLuckyNumbersDivTwo al = new TheAlmostLuckyNumbersDivTwo();
        System.out.println(al.find(1234,4321));
    }

    public int find(int a, int b) {
        int res = 0;
        for (int i = a; i <=b ; i++) {

            if (isAlmost(i)) {
                res++;
            }

        }
        return res;

    }

    private boolean isAlmost(int i) {


        boolean nonLucky = false;

       while (i > 0) {
           int last = i%10;
           if (last  != 4 & last  != 7) {
               if (nonLucky) {
                   return false;
               } else {
                   nonLucky = true;
               }
           }
           i /= 10;
       }
        return true;
    }
}
