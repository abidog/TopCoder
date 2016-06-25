package Strings;
import org.junit.Test;
import static org.junit.Assert.*;

public class SinusTest {
    @Test
    public void sinusTest(){
        Sinus sinus = new Sinus();
        String test = "Hello World!";

        System.out.println(sinus.getSinus(test));
    }
}
