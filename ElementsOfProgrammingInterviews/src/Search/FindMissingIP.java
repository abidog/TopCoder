package Search;

import java.util.BitSet;

public class FindMissingIP {
    public int findMissing(int[] arr) {
        int[] counter = new int[1 << 16];
        for (int i : arr) {
            counter[i >> 16]++;
        }

        for (int i = 0; i < (1<< 16); i++) {

            if (counter[i] < (1 << 16) ) {
                // missing upper bits
                BitSet bitVec = new BitSet(1 << 16);
                for (int j = 0; j < arr.length; j++) {
                    if (i == (arr[j] >> 16)) {
                        bitVec.set(((1 << 16) - 1) & arr[j]);
                    }
                }

                for (int j = 0; j < (1 << 16); j++) {
                    if (!bitVec.get(j)) {
                        return (i << 16) | j;
                    }
                }

            }
        }
        return -1;
    }
}
