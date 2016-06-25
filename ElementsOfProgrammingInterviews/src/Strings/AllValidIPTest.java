package Strings;
import org.junit.Test;
import static org.junit.Assert.*;

public class AllValidIPTest {

    @Test
    public void allValidIPTest() {
        AllValidIP allValidIP = new AllValidIP();
        String candid = "19216811";
        allValidIP.compute(candid);
    }

}
