import org.junit.Test;
import static org.junit.Assert.*;

public class TopViewTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] grid = new String[] {"..AA..",
 ".CAAC.",
 ".CAAC."};
		assertEquals("CA", new TopView().findOrder(grid));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] grid = new String[] {"..47..",
 "..74.."}
;
		assertEquals("ERROR!", new TopView().findOrder(grid));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] grid = new String[] {"bbb666",
 ".655X5",
 "a65AA5",
 "a65AA5",
 "a65555"};
		assertEquals("65AXab", new TopView().findOrder(grid));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] grid = new String[] {"aabbaaaaaaaaaaaaaaaaaa",
 "aabbccccccccccccccaaaa",
 "aab11111ccccccccccaaaa",
 "aab12221ccccccccccaaaa",
 "aab12221ccccccccccaaaa",
 "aab12221ccccccccccaaaa",
 "aab12221ccccccccccaaaa",
 "aab12221ccccccccccaaaa",
 "aab12221ddddddddddaaaa",
 "aab13331DDDDDDDDDDaaaa",
 "aab13331DDDDDDDDDDaaaa",
 "aa.11111DDDDDDDDDDaaaa",
 "aaaaaaaaaaaaaaaaaaaaaa"};
		assertEquals("ERROR!", new TopView().findOrder(grid));
	}
}
