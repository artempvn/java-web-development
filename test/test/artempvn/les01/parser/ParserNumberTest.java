package test.artempvn.les01.parser;

import by.artempvn.les01.exception.CustomException;
import by.artempvn.les01.parser.ParserNumber;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import static org.testng.Assert.*;

public class ParserNumberTest {

	ParserNumber parserNumber;

	@BeforeClass
	public void setUp() {
		parserNumber = new ParserNumber();
	}

	@Test(dataProvider = "findInt")
	public void findIntTest(String input, String expected) {
		String actual = parserNumber.findInt(input);
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] findInt() {
		return new Object[][] { { " 15 ", "15" }, { "15d", "" }, };
	}

	@Test(dataProvider = "findLong")
	public void findLongTest(String input, String expected) {
		String actual = parserNumber.findLong(input);
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] findLong() {
		return new Object[][] { { " 15L ", "15" }, { "15d", "" }, };
	}

	@Test(dataProvider = "findDouble")
	public void findDoubleTest(String input, String expected) {
		String actual = parserNumber.findDouble(input);
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] findDouble() {
		return new Object[][] { { " 15.3 ", "15.3" }, { " 15,3 ", "15.3" },
				{ "15L", "" }, };
	}

	@Test
	public void stringToIntTestPositive() {
		int actual = 0;
		try {
			actual = parserNumber.stringToInt("15");
		} catch (CustomException e) {
			fail("exception occurred");
		}
		int expected = 15;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void stringToIntTestNegative() throws CustomException {
		parserNumber.stringToInt("3.14");
	}

	@Test
	public void stringToLongTestPositive() {
		long actual = 0;
		try {
			actual = parserNumber.stringToLong("21474836470");
		} catch (CustomException e) {
			fail("exception occurred");
		}
		long expected = 21474836470L;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void stringToLongTestNegative() throws CustomException {
		parserNumber.stringToLong("3.14");
	}

	@Test
	public void stringToDoubleTestPositive() {
		double actual = 0;
		try {
			actual = parserNumber.stringToDouble("3.14");
		} catch (CustomException e) {
			fail("exception occurred");
		}
		double expected = 3.14;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void stringToDoubleTestNegative() throws CustomException {
		parserNumber.stringToDouble("nonDuble");
	}

	@AfterClass
	public void tierDown() {
		parserNumber = null;
	}
}
