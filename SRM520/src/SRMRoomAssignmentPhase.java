// start 11:58am
import java.util.*;
public class SRMRoomAssignmentPhase {

    public static void main(String[] args) {
        SRMRoomAssignmentPhase srm = new SRMRoomAssignmentPhase();
        int[] ratings = {1197, 1198, 1196, 1195, 1199};
        int K = 1;

        System.out.println(srm.countCompetitors(ratings, K));
    }

   public int countCompetitors(int[] ratings, int K) {
       int mine  = ratings[0];
       List<Integer> [] assigned =new ArrayList[K];

       Arrays.sort(ratings);
       int my = -1;
       for (int i = ratings.length - 1; i >= 0;) {

           for (int j = 0; j < K; j++) {

               if (i < 0) {
                   break;
               }

               if (ratings[i] == mine) {
                   my = j;
               }
               if (assigned[j] == null) {
                   assigned[j] = new ArrayList<>();
               }
               if (i < ratings.length) {
                   assigned[j].add(ratings[i--]);
               }

           }

       }
       int res = 0;
       if (my == -1 || assigned[my] == null) {
           return 0;
       }
       for (int i : assigned[my]) {
           if (i > mine) {
               res++;
           }
       }

       return res;

   }
}
