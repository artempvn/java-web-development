package test.artempvn.les01.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les01.entity.Point2D;
import by.artempvn.les01.service.ServicePoint;

public class ServicePointTest {
	ServicePoint servicePoint;
	Point2D pointA;
	Point2D pointB;

	@BeforeClass
	public void setUp() {
		servicePoint = new ServicePoint();
	}

	@Test
	public void calculateDistancePointOriginTest() {
		pointA = new Point2D("A", 3, 4);
		double actual = servicePoint.calculateDistancePointOrigin(pointA);
		double expected = 5.;
		assertEquals(actual, expected, 0.001, " Test failed as...");
	}

	@Test(dataProvider = "compareDistanceToOrigin")
	public void compareDistanceToOriginTest(Point2D one, Point2D two,
			int expected) {
		int actual = servicePoint.compareDistanceToOrigin(one, two);
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] compareDistanceToOrigin() {
		return new Object[][] {
				{ new Point2D("A", 3, 4), new Point2D("B", 4, 4), -1 },
				{ new Point2D("A", 4, 4), new Point2D("B", 3, 4), 1 },
				{ new Point2D("A", 3, 4), new Point2D("B", -3, 4), 0 } };
	}

	@AfterClass
	public void tierDown() {
		servicePoint = null;
		pointA = null;
		pointB = null;
	}

}
