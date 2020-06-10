package test.artempvn.les01.validator;

import by.artempvn.les01.validator.CheckType;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import static org.testng.Assert.*;

public class CheckTypeTest {

	CheckType checkType;

	@BeforeClass
	public void setUp() {
		checkType = new CheckType();
	}

	@DataProvider
	public Object[][] isInt() {
		return new Object[][] { { "2147483647", true }, { "nonInt", false },
				{ null, false }, };
	}

	@DataProvider
	public Object[][] isLong() {
		return new Object[][] { { "21474836478", true }, { "nonLong", false },
				{ null, false }, };
	}

	@DataProvider
	public Object[][] isDouble() {
		return new Object[][] { { "3.14", true }, { "nonDouble", false },
				{ null, false }, };
	}

	@Test(dataProvider = "isInt")
	public void isIntTest(String inputString, boolean expected) {
		boolean actual = checkType.isInt(inputString);
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(dataProvider = "isLong")
	public void isLongTest(String inputString, boolean expected) {
		boolean actual = checkType.isLong(inputString);
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(dataProvider = "isDouble")
	public void isDoubleTest(String inputString, boolean expected) {
		boolean actual = checkType.isDouble(inputString);
		assertEquals(actual, expected, " Test failed as...");
	}

	@AfterClass
	public void tierDown() {
		checkType = null;
	}

}
