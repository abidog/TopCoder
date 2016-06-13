import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class CaptureFish {


    public static void main(String[] args) {
        CaptureFish cf = new CaptureFish();
        String fish = "**OX**";
        System.out.println(new CaptureFish().getParity(fish));

    }

	public int getParity(String fish) {

        int count = 0;


        for (int i = 0; i < fish.length(); i++) {
            for (int j = i + 1; j <= fish.length() ; j++) {
                // net from i to j + 1
                char inside = '*';
                char outside = '*';
                boolean valid = true;
                for (int k = 0; k < fish.length(); k++) {
                        if (k >= i && k < j) {

                            if (fish.charAt(k) != '*') {

                                if (inside == '*') {
                                    inside = fish.charAt(k);
                                } else if (inside != fish.charAt(k)) {
                                    valid = false;
                                }
                            }

                        } else {

                            if (fish.charAt(k) != '*') {

                                if (outside == '*') {
                                    outside = fish.charAt(k);
                                } else if(outside != fish.charAt(k)){
                                    valid = false;
                                }

                            }

                        }

                    if (!valid) {
                        break;
                    }
                }


                if (valid && (inside == '*' || outside == '*' || inside != outside)) {
                    count++;
                }

            }
        }

        return count % 2;
	}
}
