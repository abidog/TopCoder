import java.util.*;

public class NewItemShopTwo {
    int T[][], C[][];
    double P[][];

    double getExpected(int customer, int index)
    {
        double p = 1.0;
        for(int i=0; i<index; i++)
            p -= P[customer][i];
        double ret = 0;
        for(int i = index; P[customer][i] > -1; i++)
            ret += P[customer][i]/p * C[customer][i];
        return ret;
    }

    public double getMaximum(String[] customers)
    {

        T = new int[2][20];
        C = new int[2][20];
        P = new double[2][20];


        for(int i=0; i<customers.length; i++)
        {
            Arrays.fill(P[i], -1);
            String[] temp = customers[i].split(" ");
            for(int j=0; j<temp.length; j++)
            {
                String[] t = temp[j].split(",");
                T[i][j] = Integer.valueOf(t[0]);
                C[i][j] = Integer.valueOf(t[1]);
                P[i][j] = Integer.valueOf(t[2])/100.0;
            }
        }

        double ret = 0.0, p1 = 1, p2 = 1;
        int t1 = 0, t2 = 0;

        for(int h=0; h<24; h++) // For each hour
            // If customer 0 walks in at this time, calculate the expected value
            if(T[0][t1]==h)
            {   ret += (P[0][t1]/p1)*p1*p2*Math.max(C[0][t1], getExpected(1, t2) );
                // update these variables, assuming he didn't come in now
                p1 -= P[0][t1];
                t1++;
            }
            // If customer 1 walks in at this time, calculate the expected value
            else if (T[1][t2]==h)
            {   ret += (P[1][t2]/p2)*p1*p2*Math.max(C[1][t2], getExpected(0, t1) );
                // update these variables, assuming he didn't come in now
                p2 -= P[1][t2];
                t2++;
            }
        return ret;
    }
}
