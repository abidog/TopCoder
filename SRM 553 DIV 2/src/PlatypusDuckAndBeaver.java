import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class PlatypusDuckAndBeaver {
	
	public int minimumAnimals(int webbedFeet, int duckBills, int beaverTails) {


        for (int d = 0; d <= duckBills; d++) {
            for (int b = 0; b <= beaverTails; b++) {
                for (int p = 0; p <= Math.max(beaverTails, duckBills); p++) {
                    int wf = d * 2 + 4 * b + 4 * p;
                    int db = d + p;
                    int bt = b + p;

                    if (wf == webbedFeet && db == duckBills && bt == beaverTails) {
                        return d + b + p;
                    }


                }
            }
        }

        return 0;
	}
}
