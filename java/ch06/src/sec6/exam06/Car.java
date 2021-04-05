package sec6.exam06;

public class Car {
	// static이 없으니 intance level
	private int speed;
	private boolean stop; // 정지상태 여부
	private final int MAX = 200;
	
	// getter
	public int getSpeed() {
		return this.speed;
	}
	// setter
	public void setSpeed(int s) {
		if(speed <= MAX && speed >= 0) {
			this.speed = s;			
		}
	}
	// getter
	public boolean isStop() {
		return stop;
	}
	// setter
	public void setStop(boolean s) {
		this.stop = s;
	}
}
