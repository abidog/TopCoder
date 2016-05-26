import java.util.Arrays;

// start 7:13pm
// End : 7:33pm
public class TheProgrammingContestDivTwo {
    public static void main(String[] args) {
        TheProgrammingContestDivTwo pc = new TheProgrammingContestDivTwo();

        int T = 47;
        int[] requiredTime =  {12, 3, 21, 6, 4, 13};
        int[] result = pc.find(T, requiredTime);


        System.out.println(result[0] +" "+result[1]);
    }
        public int[] find(int T, int[] requiredTime) {
            Arrays.sort(requiredTime);
            int sum = 0;
            int solved = 0;
            int penal = 0;
            for (int i = 0; i < requiredTime.length; i++) {
                if (sum + requiredTime[i] <=  T) {
                    sum += requiredTime[i];
                    penal += sum;
                    solved++;

                } else {
                    break;
                }
            }
            return new int[] {solved, penal};
        }

}
