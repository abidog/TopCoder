package Map;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
public class ShortestUniqueTest {

    @Test
    public void shortestUniqTest() {
        ShortestUnique shortestUnique = new ShortestUnique();
        String word = "cat";
        Set<String> words  = new HashSet<>();
        words.add("dog");
        words.add("be");
        words.add("cut");
        words.add("car");
        words.add("cat");
        System.out.println(shortestUnique.shortesUniq(word, words));

    }
}
