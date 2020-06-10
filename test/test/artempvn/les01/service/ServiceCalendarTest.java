package test.artempvn.les01.service;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les01.exception.CustomException;
import by.artempvn.les01.service.ServiceCalendar;
import static org.testng.Assert.*;

public class ServiceCalendarTest {
	ServiceCalendar serviceCalendar;

	@BeforeClass
	public void setUp() {
		serviceCalendar = new ServiceCalendar();
	}

	@Test(dataProvider = "isLeapYear")
	public void isLeapYearTestPositive(int year, boolean expected) {
		boolean actual = false;
		try {
			actual = serviceCalendar.isLeapYear(year);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] isLeapYear() {
		return new Object[][] { { 2000, true }, { 1900, false }, { 2020, true },
				{ 2021, false }, };
	}

	@Test(expectedExceptions = CustomException.class)
	public void isLeapYearTestNegative() throws CustomException {
		serviceCalendar.isLeapYear(1251);
	}

	@Test(dataProvider = "findOutNumberOfDaysPositive")
	public void findOutNumberOfDaysTestPositive(int month, int year,
			int expected) {
		int actual = 0;
		try {
			actual = serviceCalendar.findOutNumberOfDays(month, year);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] findOutNumberOfDaysPositive() {
		return new Object[][] { { 2, 2000, 29 }, { 2, 1900, 28 },
				{ 3, 2020, 31 }, };
	}

	@Test(dataProvider = "findOutNumberOfDaysNegative",
			expectedExceptions = CustomException.class)
	public void findOutNumberOfDaysTestNegative(int month, int year)
			throws CustomException {
		serviceCalendar.findOutNumberOfDays(month, year);
	}

	@DataProvider
	public Object[][] findOutNumberOfDaysNegative() {
		return new Object[][] { { 0, 2000 }, { 2, 1200 }, };
	}

	@AfterClass
	public void tierDown() {
		serviceCalendar = null;
	}
}
