package test.artempvn.les01.validator;

import by.artempvn.les01.validator.CheckValue;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import static org.testng.Assert.*;

public class CheckValueTest {

	CheckValue checkValue;

	@BeforeClass
	public void setUp() {
		checkValue = new CheckValue();
	}

	@DataProvider
	public Object[][] month() {
		return new Object[][] { { 0, false }, { 5, true }, { 13, false }, };
	}

	@DataProvider
	public Object[][] year() {
		return new Object[][] { { 1000, false }, { 2020, true },
				{ 3600, false }, };
	}

	@DataProvider
	public Object[][] square() {
		return new Object[][] { { 2, 1, true }, { 1, 2, false },
				{ 2, 0, false }, { 0, -1, false }, };
	}

	@DataProvider
	public Object[][] timeSeconds() {
		return new Object[][] { { -1, false }, { 600, true },
				{ 86401, false }, };
	}

	@DataProvider
	public Object[][] interval() {
		return new Object[][] { { 0, 10, 1, true }, { 11, 10, 1, false },
				{ 0, 10, 11, false }, { 0, 10, -1, false }, };
	}

	@Test(dataProvider = "month")
	public void CheckMonthTest(int month, boolean expected) {
		boolean actual = checkValue.checkMonth(month);
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(dataProvider = "year")
	public void checkYearTest(int year, boolean expected) {
		boolean actual = checkValue.checkYear(year);
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(dataProvider = "square")
	public void checkSquareTest(double outerSquare, double innerSquare,
			boolean expected) {
		boolean actual = checkValue.checkSquare(outerSquare, innerSquare);
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(dataProvider = "timeSeconds")
	public void checkTimeSecondsTest(int seconds, boolean expected) {
		boolean actual = checkValue.checkTimeSeconds(seconds);
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(dataProvider = "interval")
	public void checkIntervalTest(double start, double end, double step,
			boolean expected) {
		boolean actual = checkValue.checkInterval(start, end, step);
		assertEquals(actual, expected, " Test failed as...");
	}

	@AfterClass
	public void tierDown() {
		checkValue = null;
	}
}
