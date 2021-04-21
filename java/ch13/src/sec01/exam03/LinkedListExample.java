package sec01.exam03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();
		
		long startTime;
		long endTime;
		
		//ArryList 작업시간
		startTime = System.nanoTime();
		for(int i=0; i<1000000; i++) {
			list1.add(String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList 작업시간:"+(endTime-startTime));
		
		startTime = System.nanoTime();
		for(int i=0; i<1000000; i++) {
			list2.add(String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList작업시간:"+(endTime-startTime));
	}
}
