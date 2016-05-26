import java.util.HashSet;


import java.util.*;
public class GeometricProgressions {


    public static void main(String[] args) {
        GeometricProgressions gp = new GeometricProgressions();
        int b1 = 3;
        int q1 = 4;
        int n1 = 100500;
        int b2 = 48;
        int q2 = 1024;
        int n2 = 1000;

        System.out.println(gp.count(b1, q1, n1, b2, q2, n2));

    }

    class Factor {

        int[] arr;
        public Factor(int [] num) {
            this.arr = num;
        }

        public int hashCode() {
            int hash = 3;
            for (int i = 0; i < arr.length ; i++) {
                hash = (hash * arr[i] * (i + 1) % Integer.MAX_VALUE);
            }
            return hash;
        }

        public boolean equals(Object o) {
            Factor other = (Factor) o;
            if (other.arr.length != this.arr.length) {
                return false;
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != other.arr[i]) {
                    return false;
                }
            }
            return true;
        }
        public Factor add(Factor other) {
            int[] ar = new int[other.arr.length];
            for (int i = 0; i < other.arr.length; i++) {
                ar[i] = this.arr[i] + other.arr[i];
            }
            return new Factor(ar);
        }

    }
    public int count(int b1, int q1, int n1, int b2, int q2, int n2) {

        if (b2 == 0 || q2 <= 1) {
            swap(b1, b2);
            swap(q1, q2);
            swap(n1, n2);
        }

        if (b1 == 0 || q1 <= 1) {
            Set<Long> set = new HashSet<>();

            long cur = b2;
            for (int i = 0; i <= n2; i++) {
                cur *= q2;
                set.add(cur);
                if (cur > 500000000) {
                    return set.size() + n2 - i - 1;
                }
            }
            return set.size();
        }

        fillPrime();

        Set<Integer> primes = getFactor(q1, b1, q2, b2);
        List<Integer> primeList = new ArrayList<>(primes);

        Set<Integer> q1Rep = getNumPrimeFactor(q1);
        Set<Integer> q2Rep = getNumPrimeFactor(q2);
        Set<Integer> b1Rep = getNumPrimeFactor(b1);
        Set<Integer> b2Rep = getNumPrimeFactor(b2);

        int[] q1Vector = new int[primes.size()];
        int[] q2Vector = new int[primes.size()];
        int[] b1Vector = new int[primes.size()];
        int[] b2Vector = new int[primes.size()];

        Collections.sort(primeList);

        for (int i = 0; i < primeList.size(); i++) {
            int num = primeList.get(i);
            if (q1Rep.contains(num)) {
                int nm = num;
                int count = 0;
                int qq1 = q1;
                while (qq1 % nm == 0) {
                    count++;
                    qq1 /= nm;
                }
                q1Vector[i] = count;
            }

            if (q2Rep.contains(num)) {
                int count = 0;
                int nm = num;
                int qq2 = q2;
                while (qq2 % nm == 0) {
                    count++;
                    qq2 /=  nm;
                }
                q2Vector[i] = count;
            }

            if (b1Rep.contains(num)) {
                int count = 0;
                int nm = num;
                int bb1 = b1;
                while (bb1 % nm == 0) {
                    count++;
                    bb1/= nm;
                }
                b1Vector[i] = count;
            }
            if (b2Rep.contains(num)) {
                int count = 0;
                int nm = num;
                int bb2 = b2;
                while (bb2 % nm == 0) {
                    count++;
                    bb2 /= nm;

                }
                b2Vector[i] = count;
            }
        }

        Factor q1Fact = new Factor(q1Vector);
        Factor q2Fact = new Factor(q2Vector);
        Factor b1Fact = new Factor(b1Vector);
        Factor b2Fact = new Factor(b2Vector);

        Set<Factor> sets = new HashSet<>();

        for (int i = 1; i <= n1 ; i++) {

            sets.add(b1Fact);
            Factor temp= b1Fact.add(q1Fact);
            b1Fact = temp;

        }
        for (int i = 1; i <=n2 ; i++) {
            sets.add(b2Fact);
            Factor temp= b2Fact.add(q2Fact);
            b2Fact = temp;
        }


        return sets.size();


    }
    boolean [] isPrime = new boolean[1000000];
    private void fillPrime() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 3; i <1000000; i+=2) {
            if (isPrime[i]) {
                for (int j = i + i; j < 1000000 ; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
    }
    private Set<Integer> getNumPrimeFactor(int a) {
        Set<Integer> set = new HashSet<>();
        int i = 2;
        while (i <= a) {
            if (isPrime[i] && a % i == 0) {
                set.add(i);
                while (a % i == 0) {
                    a /= i;
                }
            }
            i++;
        }
        return set;
    }
    private Set<Integer> getFactor(int q1, int q2, int b1, int b2) {

        Set<Integer> primes = new HashSet<>();
        primes.addAll(getNumPrimeFactor(q1));
        primes.addAll(getNumPrimeFactor(q2));
        primes.addAll(getNumPrimeFactor(b1));
        primes.addAll(getNumPrimeFactor(b2));

        return primes;
    }

    private void swap(int p, int q) {
        int temp = p;
        p = q;
        q = temp;
    }
}
