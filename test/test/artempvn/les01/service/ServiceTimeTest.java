package test.artempvn.les01.service;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import java.util.Arrays;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import by.artempvn.les01.exception.CustomException;
import by.artempvn.les01.service.ServiceTime;

public class ServiceTimeTest {
	ServiceTime serviceTime;

	@BeforeClass
	public void setUp() {
		serviceTime = new ServiceTime();
	}

	@Test
	public void convertSecondsToHmsTestPositive() {
		int[] actual = null;
		try {
			actual = serviceTime.convertSecondsToHms(3665);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		int[] expected = { 1, 1, 5 };
		boolean isEqual = Arrays.equals(actual, expected);
		assertTrue(isEqual, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void convertSecondsToHmsTestNegative() throws CustomException {
		serviceTime.convertSecondsToHms(-1);
	}

	@AfterClass
	public void tierDown() {
		serviceTime = null;

	}
}
