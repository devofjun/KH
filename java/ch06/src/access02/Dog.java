package access02;

public class Dog {
	public String name;
	int age;
	private float weight;
	
	public void eat() {
		weight++;
	}
	
	// Getter 라고 불리는 메소드 형태
	public float getWeight() {
		return weight;
	}
	
	// Setter 라고 불리는 메소드 형태
	public void setWeight(float weight) {
		if(weight > 0) { // 몸무게가 음수가 될 수 없음.
			this.weight = weight;
		}
	}
}
