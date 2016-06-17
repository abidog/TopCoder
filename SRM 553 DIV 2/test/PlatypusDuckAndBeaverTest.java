import org.junit.Test;
import static org.junit.Assert.*;

public class PlatypusDuckAndBeaverTest {
	
	@Test(timeout=2000)
	public void test0() {
		int webbedFeet = 824;
		int duckBills = 309;
		int beaverTails = 81;

		assertEquals(331, new PlatypusDuckAndBeaver().minimumAnimals(webbedFeet, duckBills, beaverTails));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int webbedFeet = 0;
		int duckBills = 0;
		int beaverTails = 0;
		assertEquals(0, new PlatypusDuckAndBeaver().minimumAnimals(webbedFeet, duckBills, beaverTails));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int webbedFeet = 10;
		int duckBills = 2;
		int beaverTails = 2;
		assertEquals(3, new PlatypusDuckAndBeaver().minimumAnimals(webbedFeet, duckBills, beaverTails));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int webbedFeet = 60;
		int duckBills = 10;
		int beaverTails = 10;
		assertEquals(20, new PlatypusDuckAndBeaver().minimumAnimals(webbedFeet, duckBills, beaverTails));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int webbedFeet = 1000;
		int duckBills = 200;
		int beaverTails = 200;
		assertEquals(300, new PlatypusDuckAndBeaver().minimumAnimals(webbedFeet, duckBills, beaverTails));
	}
}
