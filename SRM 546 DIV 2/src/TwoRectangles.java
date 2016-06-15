import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class TwoRectangles {

    class Rectangle{
        int[] lowerLeft;
        int[] lowerRight;
        int[] upperLeft;
        int[] upperRight;
        public Rectangle(int[] ll, int[] lr, int[] ul, int[] ur) {
            lowerLeft = ll;
            lowerRight = lr;
            upperLeft = ul;
            upperRight = ur;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[] {0,0,1,1};
        int[] B = new int[] {1,1,5,2};
        TwoRectangles tr = new TwoRectangles();
        System.out.println(tr.describeIntersection(A,B));
    }

	public String describeIntersection(int[] A, int[] B) {

        // a <= x <= b
        int alx = A[0];
        int aux = A[2];
        int aly = A[1];
        int auy = A[3];

        int blx = B[0];
        int bux = B[2];
        int bly = B[1];
        int buy = B[3];

        int xs = Math.max(alx, blx);
        int xe = Math.min(aux, bux);

        int ys = Math.max(aly, bly);
        int ye = Math.min(auy, buy);

        if ( xe > xs && ye > ys ) {
            return "rectangle";
        }
        if ((xe == xs && ye > ys) || (ye == ys && xe > xs)) {
            return "segment";
        }
        if (xs == xe && ys == ye) {
            return "point";
        }



        return "none";
	}
}
