package ex05;

public class Shape {
	
	private int startX;
	private int startY;
	private int stopX;
	private int stopY;
	private ShapeType type;
	public Shape() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shape(int startX, int startY, int stopX, int stopY, ShapeType type) {
		super();
		this.startX = startX;
		this.startY = startY;
		this.stopX = stopX;
		this.stopY = stopY;
		this.type = type;
	}
	public int getStartX() {
		return startX;
	}
	public void setStartX(int startX) {
		if(startX >= 0) {
			this.startX = startX;			
		}
	}
	public int getStartY() {
		return startY;
	}
	public void setStartY(int startY) {
		if(startY >= 0) {
			this.startY = startY;
		}
	}
	public int getStopX() {
		return stopX;
	}
	public void setStopX(int stopX) {
		if(stopX >= 0) {
			this.stopX = stopX;
		}
	}
	public int getStopY() {
		return stopY;
	}
	public void setStopY(int stopY) {
		if(stopY >= 0) {
			this.stopY = stopY;
		}
	}
	public ShapeType getType() {
		return type;
	}
	public void setType(ShapeType type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Shape [startX=" + startX + ", startY=" + startY + ", stopX=" + stopX + ", stopY=" + stopY + ", type="
				+ type + "]";
	}
	
	
}
