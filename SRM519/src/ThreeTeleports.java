import java.util.*;

public class ThreeTeleports {




    class TelePort{
        int[] n1;
        int[] n2;
        public TelePort(int[] n1, int[] n2){
            this.n1 = n1;
            this.n2 = n2;
        }
    }
    public static void main(String[] args) {
        ThreeTeleports tt = new ThreeTeleports();
        String[] teleports = {"3 10 5200 4900", "12212 8699 9999 30011", "12200 8701 5203 4845"} ;
        int res = tt.shortestDistance(3, 7, 10000, 30000, teleports);
        System.out.println(res);
    }
    public long distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }


    public long distance(int x1, int y1, TelePort t) {
        return Math.abs(x1 - t.n1[0]) + Math.abs(y1 - t.n1[1]);
    }
    public long distance(TelePort t, int x1, int y1) {
        return Math.abs(x1 - t.n2[0]) + Math.abs(y1 - t.n2[1]);
    }
    public long distance(TelePort t, TelePort t2) {
        return Math.abs(t2.n1[0] - t.n2[0]) + Math.abs(t2.n1[1] - t.n2[1]);
    }
    public int shortestDistance(int xMe, int yMe, int xHome, int yHome, String[] teleports) {
        int[][] orderSet = {{0,1,2}, {0,2,1}, {1,0,2}, {1,2,0}, {2, 0, 1}, {2,1,0}};
        TelePort[] tele = new TelePort[6];
        for (int i = 0; i < 6; i+=2) {
            String[] teleCoor = teleports[i/2].split(" ");
            int[] n1 = {Integer.parseInt(teleCoor[0]), Integer.parseInt(teleCoor[1])};
            int[] n2 = {Integer.parseInt(teleCoor[2]), Integer.parseInt(teleCoor[3])};
            tele[i] = new TelePort(n1, n2);
            tele[i + 1] = new TelePort(n2, n1);

        }

        long dis = Integer.MAX_VALUE;


        for (int i = 0; i <= 3; i++) {

            if (i == 0) {
                dis = Math.min(dis, distance(xMe, yMe, xHome, yHome));
            } else if (i == 1) {
                // use teleport jTh
                for (int j = 0; j < 6 ; j++) {
                    TelePort port = tele[j];
                    long dis1 = distance(xMe, yMe, port.n1[0], port.n1[1]) + 10 + distance(port.n2[0], port.n2[1], xHome, yHome);
                    dis = Math.min(dis, dis1);
                }
                // use two teleports
            } else if (i == 2) {

                for (int j = 0; j < 6; j++) {
                    for (int k = j + 1; k < 6 ; k++) {
                        TelePort t1 = tele[j];
                        TelePort t2 = tele[k];
                        long dis1 = distance(xMe, yMe, t1.n1[0], t1.n1[1]) + 10 + distance(t1.n2[0], t1.n2[1], t2.n1[0], t2.n1[1]);
                        dis1 += 10+ distance(t2.n2[0], t2.n2[1], xHome, yHome);
                        dis = Math.min(dis, dis1);
                        t1 = tele[k];
                        t2 = tele[j];
                        dis1 = distance(xMe, yMe, t1.n1[0], t1.n1[1]) + 10 + distance(t1.n2[0], t1.n2[1], t2.n1[0], t2.n1[1]);
                        dis1 += 10+ distance(t2.n2[0], t2.n2[1], xHome, yHome);
                        dis = Math.min(dis, dis1);
                    }
                }

            } else {

                int mask = 1 << 6;
                List<List<Integer>> subset = new ArrayList<>();
                for (int j = 0; j < mask; j++) {
                    if (Integer.bitCount(j) == 3) {
                        List<Integer> sub = new ArrayList<>();
                        int count = j;
                        int index = 0;
                        while (count > 0) {
                            if ((count & 0x1) == 1) {
                                sub.add(index);
                            }
                            index++;
                            count >>= 1;
                        }
                        subset.add(sub);
                    }
                }

                for (List<Integer> telePath : subset) {
                    TelePort[] order = {tele[telePath.get(0)],tele[telePath.get(1)], tele[telePath.get(2)]};
                    for (int[] or : orderSet) {
                        TelePort t1 = order[or[0]];
                        TelePort t2 = order[or[1]];
                        TelePort t3 = order[or[2]];
                        long dis1 =  distance(xMe, yMe, t1) + 10 + distance(t1, t2) + 10 + distance(t2, t3) + 10 + distance(t3, xHome, yHome);
                        dis = Math.min(dis, dis1);
                    }




                }
            }
        }

        return (int)dis;
    }
}
