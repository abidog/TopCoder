import org.junit.Test;
import static org.junit.Assert.*;

public class ConvertibleStringsTest {
	
	@Test(timeout=2000)
	public void test0() {
		String A = "DD";
		String B = "FF";
		assertEquals(0, new ConvertibleStrings().leastRemovals(A, B));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String A = "AAAA";
		String B = "ABCD";
		assertEquals(3, new ConvertibleStrings().leastRemovals(A, B));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String A = "AAIAIA";
		String B = "BCDBEE";
		assertEquals(3, new ConvertibleStrings().leastRemovals(A, B));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String A = "ABACDCECDCDAAABBFBEHBDFDDHHD";
		String B = "GBGCDCECDCHAAIBBFHEBBDFHHHHE";
		assertEquals(9, new ConvertibleStrings().leastRemovals(A, B));
	}
}
