import org.junit.Test;
import static org.junit.Assert.*;

public class Over9000RocksTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] lowerBound = new int[] {9000};
		int[] upperBound = new int[] {9001};
		assertEquals(1, new Over9000Rocks().countPossibilities(lowerBound, upperBound));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] lowerBound = new int[] {9000, 1, 10};
		int[] upperBound = new int[] {9000, 2, 20};
		assertEquals(15, new Over9000Rocks().countPossibilities(lowerBound, upperBound));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] lowerBound = new int[] {1001, 2001, 3001, 3001};
		int[] upperBound = new int[] {1003, 2003, 3003, 3003};
		assertEquals(9, new Over9000Rocks().countPossibilities(lowerBound, upperBound));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] lowerBound = new int[] {9000,90000,1,10};
		int[] upperBound = new int[] {9000,90000,3,15};
		assertEquals(38, new Over9000Rocks().countPossibilities(lowerBound, upperBound));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] lowerBound = new int[] {1,1,1,1,1,1};
		int[] upperBound = new int[] {3,4,5,6,7,8};
		assertEquals(0, new Over9000Rocks().countPossibilities(lowerBound, upperBound));
	}
}
