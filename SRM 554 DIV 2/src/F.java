import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {


        public static void main(String[] args) throws IOException {

            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String np = "P=NP";
            int num = Integer.parseInt(bf.readLine());

            for (int i = 0; i < num; i++) {
                String line = bf.readLine();
                if (line.equals(np)) {
                    System.out.println("skipped");
                } else {
                    String[] nums = line.replaceAll("[+]"," ").split(" ");
                    System.out.println(Integer.parseInt(nums[0])+ Integer.parseInt(nums[1]));
                }
            }


        }
}
