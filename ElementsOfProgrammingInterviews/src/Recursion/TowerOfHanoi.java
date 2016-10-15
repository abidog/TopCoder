package Recursion;

public class TowerOfHanoi {

    public String hanoi(int n, int from, int to) {
        if (n == 1) {
            return "move from peg" + from+ " to peg"+to+" \n";
        } else {
            int helpPeg = 6 - from - to;
            String sol1 = hanoi(n - 1, from, helpPeg);
            String myStep = "move from peg"+ from+" to peg"+to+" \n";
            String sol2 = hanoi(n-1, helpPeg, to);
            return sol1 + myStep + sol2;
        }
    }
}
