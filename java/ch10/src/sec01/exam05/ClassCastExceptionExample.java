package sec01.exam05;

public class ClassCastExceptionExample {
	public static void main(String[] args) {
		Animal ani1 = new Dog();
		changeDog(ani1);
		Animal ani2 = new Cat();
		changeDog(ani2);
	}
	
	public static void changeDog(Animal ani) {
		Dog dog = (Dog)ani;
		System.out.println(dog);
	}
	
	
}
class Animal{}
class Cat extends Animal{}
class Dog extends Animal{}
