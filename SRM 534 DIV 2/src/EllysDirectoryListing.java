import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class EllysDirectoryListing {

    public static void main(String[] args) {
        String[] files = new String[] {".",".."};

        new EllysDirectoryListing().getFiles(files);

    }

    public String[] getFiles(String[] files) {

        String dot = ".";
        String dDot = "..";

        int last = files.length - 1;
        int lst = files.length - 1;

        boolean d = false;
        boolean dd = false;
        for (int i = 0; i <= last; i++) {
            if ((files[lst].equals(".") || files[lst].equals("..")) &&  ((files[lst - 1].equals(".") || files[lst - 1].equals("..")))) {
                break;
            }
            if (files[i].equals(dot) ) {

                String temp = files[last];
                files[last] = files[i];
                files[i] = temp;
                last--;
                i--;


            }
            if (i >= 0 && files[i].equals(dDot)) {
                String temp = files[last];
                files[last] = files[i];
                files[i] = temp;
                last--;
                i--;
            }


        }

        return files;
	}
}
