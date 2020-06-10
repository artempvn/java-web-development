package test.artempvn.les01.service;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les01.exception.CustomException;
import by.artempvn.les01.service.ServiceDigit;
import static org.testng.Assert.*;

public class ServiceDigitTest {
	ServiceDigit serviceDigit;

	@BeforeClass
	public void setUp() {
		serviceDigit = new ServiceDigit();
	}

	@Test
	public void findLastDigitTest() {
		int actual = serviceDigit.findLastDigit(31);
		int expected = 1;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test
	public void squareNumberTest() {
		int actual = serviceDigit.squareNumber(5);
		int expected = 25;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test
	public void findLastDigitOfSquaredLastDigitTest() {
		int actual = serviceDigit.findLastDigitOfSquaredLastDigit(27);
		int expected = 9;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(dataProvider = "isEvenNumber")
	public void isEvenNumberTest(int number, boolean expected) {
		boolean actual = serviceDigit.isEvenNumber(number);
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] isEvenNumber() {
		return new Object[][] { { 24, true }, { 25, false }, { 0, false } };
	}

	@Test(dataProvider = "isEnoughEvenNumbers")
	public void isEnoughEvenNumbersTestPositive(boolean expected,
			int... someInt) {
		boolean actual = false;
		try {
			actual = serviceDigit.isEnoughEvenNumbers(someInt);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] isEnoughEvenNumbers() {
		return new Object[][] { { true, 2, 4, 1, 1 }, { false, 2, 1, 1, 1 } };
	}

	@Test(expectedExceptions = CustomException.class)
	public void isEnoughEvenNumbersTestNegative() throws CustomException {
		serviceDigit.isEnoughEvenNumbers(2, 2);
	}

	@Test(dataProvider = "isPerfect")
	public void isPerfectTest(int number, boolean expected) {
		boolean actual = serviceDigit.isPerfect(number);
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] isPerfect() {
		return new Object[][] { { 5, false }, { 496, true }, { 285, false } };
	}

	@AfterClass
	public void tierDown() {
		serviceDigit = null;
	}
}
