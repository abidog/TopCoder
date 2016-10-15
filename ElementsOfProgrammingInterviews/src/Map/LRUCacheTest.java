package Map;

import org.junit.Test;
import static org.junit.Assert.*;

public class LRUCacheTest {
    @Test
    public void lruCacheTest() {
        LRUCache lruCache = new LRUCache(1);

        lruCache.set(2, 1);
        lruCache.get(2);
        lruCache.set(3,2);
        lruCache.get(2);
        lruCache.get(3);




    }
}
