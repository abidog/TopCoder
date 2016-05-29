import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class YetAnotherORProblem2 {

    // memo[T][mequal]
    int[][] memo;
    int R;
    int N;


    public int rec (int T, int nequal) {
        int res = 0;
        int bit = (R >> T) & 0x1;
        if (T == 0) {
            return 1;
        } else if (memo[T][nequal] != -1) {
            return memo[T][nequal];
        } else if (nequal == N) {


            if (bit == 0) {
                res += rec(T - 1, nequal);

            } else {
                // use all zeros
                res += rec(T - 1, 0);
                // use only 1 in one of the row
                res += N * rec(T - 1, 1);

            }
        } else if (nequal == 1) {
            if (bit == 1) {
                // set all to zero
                res += rec(T - 1, 0);
                // use 0 in the equal row, and one of the others is 1
                res += (N - 1) * rec(T - 1, 0);

                res += rec(T - 1, 1);
            }
        } else if (nequal == 0) {
            // place 0 in all of them.
            res += rec(T - 1, 0);
            // place of the row to 1
            res += N  * rec(T - 1, 0);
        }
        memo[T][nequal] = res;
        return  memo[T][nequal];
    }



	public int countSequences(int N, int R) {
        // A1 + A2 + .... + An-1 < N
        // An < R
        // add each single one of the An, N of them, each of them between 0 and R,
        // when you add their logical or operation will be equavalent.
        // Think about adding each single of them up, when we apply to logical and + operators
        // logical | will be equvalent if only one of the row has 1, and other rows are all zero.
        // each row entree needs to be less than R, and number of row entrees are N.
        // f(T, nequal), T is column number, nequal is number of rows are equal to R
        // if T == 0, we managed to get first column, so we return 1
        // if nequal is R means all the rows are equal to R, then we can check the pth bit, if the
        // pth bit is 1, we can place 0 in this row, and place 1 in all other rows
        // if (pth bit 1)
        // res += Nf(T-1, 1) // place one of the 1 bit, in one of the N row, since one of the row will be
        // same as R, nequal will be 1.
        memo = new int[30][N + 1];
        this.N = N;
        this.R = R;
        rec(30, N);
        return memo[30][N];
	}
}
