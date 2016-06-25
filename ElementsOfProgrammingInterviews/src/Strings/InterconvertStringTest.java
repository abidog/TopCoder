package Strings;

import org.junit.Test;
import static org.junit.Assert.*;


public class InterconvertStringTest {
    @Test
    public void interconvertStringTest(){
        InterconvertString interconvertString = new InterconvertString();
        int num = -123;
        String exp = "-123";
        assertEquals(exp, interconvertString.intToString(num));
        assertEquals(num, interconvertString.stringToInt(exp));
    }
}
