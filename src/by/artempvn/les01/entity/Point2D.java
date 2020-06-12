package by.artempvn.les01.entity;

public class Point2D {
	private String name;
	private double coordinateX;
	private double coordinateY;
	
	public String getName() {
		return name;
	}
	public double getCoordinateX() {
		return coordinateX;
	}
	public double getCoordinateY() {
		return coordinateY;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCoordinateX(double coordinateX) {
		this.coordinateX = coordinateX;
	}
	public void setCoordinateY(double coordinateY) {
		this.coordinateY = coordinateY;
	}
	
	public Point2D() {
	}
	
	public Point2D(String name, double coordinateX, double coordinateY) {
		this.name = name;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(coordinateX);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(coordinateY);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2D other = (Point2D) obj;
		if (Double.doubleToLongBits(coordinateX) !=
				Double.doubleToLongBits(other.coordinateX))
			return false;
		if (Double.doubleToLongBits(coordinateY) != 
				Double.doubleToLongBits(other.coordinateY))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Point2D [name=");
		builder.append(name);
		builder.append(", coordinateX=");
		builder.append(coordinateX);
		builder.append(", coordinateY=");
		builder.append(coordinateY);
		builder.append("]");
		return builder.toString();
	}

}
