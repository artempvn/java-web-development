package test.artempvn.les01.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import by.artempvn.les01.exception.CustomException;
import by.artempvn.les01.service.ServiceSquareCircle;

public class ServiceSquareCircleTest {
	ServiceSquareCircle serviceSquareCircle;

	public boolean isArraysEqual(double[] one, double[] two) {
		boolean isEqual = true;
		double accuracy = 0.001;
		for (int i = 0; i < one.length; i++) {
			if (Math.abs(one[i] - two[i]) > accuracy) {
				isEqual = false;
			}
		}
		return (isEqual);
	}

	@BeforeClass
	public void setUp() {
		serviceSquareCircle = new ServiceSquareCircle();
	}

	@Test
	public void calculateSideBySquareTestPositive() {
		double actual = 0;
		try {
			actual = serviceSquareCircle.calculateSideBySquare(4.);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		double expected = 2.;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void calculateSideBySquareTestNegative() throws CustomException {
		serviceSquareCircle.calculateSideBySquare(-1.);
	}

	@Test
	public void calculateSquareByDiagonalCircumcircleTestPositive() {
		double actual = 0;
		try {
			actual = serviceSquareCircle
					.calculateSquareByDiagonalCircumcircle(4.);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		double expected = 8.;
		assertEquals(actual, expected, 0.001, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void calculateSquareByDiagonalCircumcircleTestNegative()
			throws CustomException {
		serviceSquareCircle.calculateSquareByDiagonalCircumcircle(-1.);
	}

	@Test
	public void calculateInnerSquareByOuterTestPositive() {
		double actual = 0;
		try {
			actual = serviceSquareCircle.calculateInnerSquareByOuter(16.);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		double expected = 8.;
		assertEquals(actual, expected, 0.001, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void calculateInnerSquareByOuterTestNegative()
			throws CustomException {
		serviceSquareCircle.calculateInnerSquareByOuter(-1.);
	}

	@Test
	public void calculateRatioSquareTestPositive() {
		double actual = 0;
		try {
			actual = serviceSquareCircle.calculateRatioSquare(8., 4.);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		double expected = 2.;
		assertEquals(actual, expected, 0.001, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void calculateRatioSquareTestNegative() throws CustomException {
		serviceSquareCircle.calculateRatioSquare(5., 0);
	}

	@Test
	public void calculateSquareOfCircleByRadiusTestPositive() {
		double actual = 0;
		try {
			actual = serviceSquareCircle.calculateSquareOfCircleByRadius(2.);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		double expected = 12.5664;
		assertEquals(actual, expected, 0.001, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void calculateSquareOfCircleByRadiusTestNegative()
			throws CustomException {
		serviceSquareCircle.calculateSquareOfCircleByRadius(-1.);
	}

	@Test
	public void calculateLengthOfCircumferenceByRadiusTestPositive() {
		double actual = 0;
		try {
			actual = serviceSquareCircle
					.calculateLengthOfCircumferenceByRadius(2.);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		double expected = 12.5664;
		assertEquals(actual, expected, 0.001, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void calculateLengthOfCircumferenceByRadiusTestNegative()
			throws CustomException {
		serviceSquareCircle.calculateLengthOfCircumferenceByRadius(-1.);
	}

	@Test
	public void calculateSquareLengthByRadiusTestPositive() {
		double[] actual = null;
		try {
			actual = serviceSquareCircle.calculateSquareLengthByRadius(3.);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		double[] expected = { 28.2743, 18.8496 };
		boolean isEqual = isArraysEqual(actual, expected);
		assertTrue(isEqual, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void calculateSquareLengthByRadiusTestNegative()
			throws CustomException {
		serviceSquareCircle.calculateSquareLengthByRadius(-1.);
	}

	@AfterClass
	public void tierDown() {
		serviceSquareCircle = null;
	}
}
