public class KadaneGasCircular {

    class Triplet{
        int start;
        int sum;
        int end;
        public Triplet(int sum, int start, int end) {
            this.start = start;
            this.sum = sum;
            this.end = end;
        }
    }
    // assume there is postive number
    public Triplet kadane(int[] arr) {
        int start = 0;
        int maxSoFar = 0;
        int max = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            maxSoFar += arr[i];
            if (maxSoFar < 0) {
                maxSoFar = 0;
                start = i + 1;
            } else {
                if (maxSoFar > max) {
                    max = maxSoFar;
                    end = i;
                }

            }
        }
        return new Triplet(max, start, end );
    }


    public Triplet maxWrapKadane(int[] arr) {
        Triplet straightKadane = kadane(arr);
        // check if there is wrapping

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            arr[i] = -arr[i];
        }

        Triplet wrappedKadane = kadane(arr);

        if (wrappedKadane.sum + sum > straightKadane.sum) {
            straightKadane.sum = (wrappedKadane.sum + sum) ;
            straightKadane.start = wrappedKadane.end + 1;
            straightKadane.end = wrappedKadane.start - 1;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -arr[i];
        }


        return straightKadane;

    }

    public int gasCirclular(int [] gas, int[] dist) {
        if (gas == null || dist == null) {
            return -1;
        }
        int[] arr =new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            arr[i] = gas[i] - dist[i];
        }

        Triplet kadane = maxWrapKadane(arr);
        int start = kadane.start;
        int end = start == 0 ? arr.length - 1 : start - 1;
        int tank = 0 ;

        do {
            tank += arr[start];
            start = (start + 1) % arr.length;
            if (tank < 0) {
                return -1;
            }
        } while (start !=  kadane.start);
        return kadane.start;

    }

}
