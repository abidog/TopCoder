package Strings;
import org.junit.Test;
import static org.junit.Assert.*;

public class TextJustifyTest {
    @Test
    public void textJustify() {
        TextJustify textJustify = new TextJustify();
        String[] w = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(textJustify.fullJustify(w,16));
    }
}
