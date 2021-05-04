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
			bos = new BufferedOutputStream(System.out,1024); // ����Ұ��� ������ ������
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
				bos.write(data); // ���۸� ���� �ð��� ����ȴ�. (1MB 1��)
				//System.out.println(data); // ���۸� ���� �ʰ� ����ϰ� �Ǹ� �ð��� �����ɸ���. (1MB 5��)
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
