package ex05;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedOutputStreamEx {
	public static void main(String[] args) {
		
		String filePath = "G:/stream/test3.txt";
		FileReader fr = null;
		BufferedOutputStream bos = null;
		
		long startTime = System.currentTimeMillis();
		try {
			fr = new FileReader(filePath);
			bos = new BufferedOutputStream(System.out,1024); // 출력할곳과 버퍼의 사이즈
			while(true) {
				int data = fr.read();
				if(data == -1) {
					long endTime = System.currentTimeMillis();
					System.out.println();
					System.out.println("------------");
					System.out.println(endTime - startTime);
					System.out.println("------------");
					return;
				}
				bos.write(data); // 버퍼를 쓰면 시간이 단축된다. (1MB 1초)
				//System.out.println(data); // 버퍼를 쓰지 않고 출력하게 되면 시간이 오래걸린다. (1MB 5초)
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bos.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
