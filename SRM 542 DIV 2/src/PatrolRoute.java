import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class PatrolRoute {

    public static void main(String[] args) {
        int X = 3;
        int Y = 3;
        int minT = 1;
        int maxT = 20000;
        System.out.println(new PatrolRoute().countRoutes(X, Y, minT, maxT));
    }

    int mod = 1000000007;
	public int countRoutes(int X, int Y, int minT, int maxT) {

        long count = 0;
        for (int a = 0; a < X; a++) {
            for (int b = a + 1; b < X; b++) {
                for (int c = b + 1; c < X; c++) {
                    if (a != b && b != c && a != c) {

                        for (int x = 0; x < Y; x++) {
                            for (int y = x + 1; y < Y; y++) {
                                for (int z = y + 1; z < Y; z++) {
                                    if (x != y && y != z && z != x) {
                                     //
                                        long atob = Math.abs(b - a) + Math.abs(y - x);
                                        long btoc = Math.abs(c - b) + Math.abs(z - y);
                                        long ctoa = Math.abs(c - a) + Math.abs(z - x);
                                        long total = atob + btoc + ctoa;
                                        if (total >= minT && total <= maxT) {
                                            count++;
                                        }
                                        count %= mod;
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
        
        return (int)count;
	}
}
