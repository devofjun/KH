package sec01.exam01;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Java");
		//System.out.println("list 크기:"+list.size());
		//System.out.println("list[0]:"+list.get(0));
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("iBaTIS");
		System.out.println("list 크기:"+list.size());
		
		//list에서 특정 인덱스의 데이터 가져오기
		// 2번째 : list[2] -> list.get(2);
		//String str = list.get(2);
		//System.out.println("str:"+str);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("-----------------------");
		for(String data : list) {
			System.out.println(data);
		}
	}
}
