public class GasStation {

    public int gasStationCircle(int[] gas, int[] dist) {

        int start = -1;
        int end = 0;
        int tank = 0;
        boolean visitedOnce = false;
        while (start != end) {
            tank += gas[end] - dist[end];
            if (start == -1) {
                start = end;
            }

            if (end == gas.length - 1 && !visitedOnce) {
                visitedOnce = true;
            } else if (end == gas.length - 1 && visitedOnce) {
                return -1;
            }
            if (tank < 0) {
                tank = 0;
                start = -1;
            }
            end = (end + 1) % gas.length;

        }
        return start;
    }
}
