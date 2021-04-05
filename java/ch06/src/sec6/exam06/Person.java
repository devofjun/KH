package sec6.exam06;

public class Person {
	private String name;
	private int age;
	private float weigth;
	
	
	
	public Person(String name, int age, float weigth) {
		super();
		this.name = name;
		this.age = age;
		this.weigth = weigth;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getWeigth() {
		return weigth;
	}
	public void setWeigth(float weigth) {
		this.weigth = weigth;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weigth=" + weigth + "]";
	}
	
}
