package test.artempvn.les01.service;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les01.exception.CustomException;
import by.artempvn.les01.service.ServiceFunction;
import static org.testng.Assert.*;

public class ServiceFunctionTest {
	ServiceFunction serviceFunction;

	public boolean isArraysEqual(double[][] one, double[][] two) {
		boolean isEqual = true;
		double accuracy = 0.001;
		for (int i = 0; i < one.length; i++) {
			for (int j = 0; j < one[i].length; j++) {
				if (Math.abs(one[i][j] - two[i][j]) > accuracy) {
					isEqual = false;
				}
			}
		}
		return (isEqual);
	}

	@BeforeClass
	public void setUp() {
		serviceFunction = new ServiceFunction();
	}

	@Test
	public void calculateFunctionTask8_1Test() {
		double actual = serviceFunction.calculateFunctionTask8_1(3.);
		double expected = 9.;
		assertEquals(actual, expected, 0.001, " Test failed as...");
	}

	@Test
	public void calculateFunctionTask8_2Test() {
		double actual = serviceFunction.calculateFunctionTask8_2(2.);
		double expected = 0.5;
		assertEquals(actual, expected, 0.001, " Test failed as...");
	}

	@Test(dataProvider = "calculateFunctionTask8")
	public void calculateFunctionTask8Test(double x, double expected) {
		double actual = serviceFunction.calculateFunctionTask8(x);
		assertEquals(actual, expected, 0.001, " Test failed as...");
	}

	@DataProvider
	public Object[][] calculateFunctionTask8() {
		return new Object[][] { { 3., 9. }, { 2., 0.5 } };
	}

	@Test
	public void calculateFunctionTask10Test() {
		double actual = serviceFunction.calculateFunctionTask10(1.0472);
		double expected = 1.7321;
		assertEquals(actual, expected, 0.001, " Test failed as...");
	}

	@Test(dataProvider = "calculateFunctionTask10Interval")
	public void calculateFunctionTask10IntervalTestPositive(double start,
			double end, double step, double[][] expected) {
		double[][] actual = null;
		try {
			actual = serviceFunction.calculateFunctionTask10Interval(start, end,
					step);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		boolean isEqual = isArraysEqual(actual, expected);
		assertTrue(isEqual, " Test failed as...");
	}

	@DataProvider
	public Object[][] calculateFunctionTask10Interval() {
		return new Object[][] {
				{ 0, 3, 1,
						new double[][] { { 0, 0 }, { 1, 1.5574 }, { 2, -2.185 },
								{ 3, -0.1425 } } },
				{ 0, 3, 2, new double[][] { { 0, 0 }, { 2, -2.185 },
						{ 3, -0.1425 } } } };
	}

	@Test(expectedExceptions = CustomException.class)
	public void calculateFunctionTask10IntervalTestNegative()
			throws CustomException {
		serviceFunction.calculateFunctionTask10Interval(2, 1, 5);
	}

	@AfterClass
	public void tierDown() {
		serviceFunction = null;
	}
}
