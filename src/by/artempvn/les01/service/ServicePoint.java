package by.artempvn.les01.service;

import by.artempvn.les01.entity.Point2D;

public class ServicePoint {
	static final double PRECISION = 0.0001;

	public double calculateDistancePointOrigin(Point2D point) {
		double distance = Math.hypot(point.getCoordinateX(),
				point.getCoordinateY());
		return (distance);
	}

	public int compareDistanceToOrigin(Point2D one, Point2D two) {
		double distanceA = calculateDistancePointOrigin(one);
		double distanceB = calculateDistancePointOrigin(two);
		int compareDistance;
		compareDistance = (distanceA > distanceB) ? 1 : -1;
		if (Math.abs(distanceA - distanceB) <= PRECISION) {
			compareDistance = 0;
		}
		return compareDistance;
	}

}
