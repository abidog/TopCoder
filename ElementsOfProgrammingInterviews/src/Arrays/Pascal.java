package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Pascal {

        public List<Integer> pascal(int n) {
            List<Integer> prev = new ArrayList<>();
            prev.add(1);
            prev.add(1);
            for (int i = 3; i <= n; i++) {
                List<Integer> next = new ArrayList<>();
                next.add(1);
                for (int j = 1; j < prev.size(); j++) {
                    next.add(prev.get(j) + prev.get(j - 1));
                }
                next.add(1);
                prev = next;
            }
            return prev;
        }

}
