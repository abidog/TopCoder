
// start 4:23pm
// end 4:44pm

public class SlimeXSlimesCity {
    public static void main(String[] args) {
        SlimeXSlimesCity sx = new SlimeXSlimesCity();
        System.out.println(sx.merge(new int[]{1000000000, 1000000000}));
    }
    public int merge(int[] population) {
        long[] pop = new long[population.length];
        for (int i = 0; i < population.length; i++) {
            pop[i] = population[i];
        }
        int res = 0;
        for (int i = 0; i < pop.length; i++) {

            // can I name it ith ?
            boolean[] used = new boolean[pop.length];
            int numUsed = 1;
            used[i] = true;
            long iTotal = pop[i];
            while (true) {
                boolean isThereSmaller = false;

                for (int j = 0; j < pop.length; j++) {
                    if (!used[j] && pop[j] <= iTotal) {
                        iTotal += pop[j];
                        used[j] = true;
                        numUsed++;
                        isThereSmaller = true;
                    }
                }
                if (!isThereSmaller) {
                    break;
                }

            }
            if (numUsed == pop.length) {
                res++;
            }

        }
        return res;
    }
}
