package ex04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderEx {
	public static void main(String[] args) {
		String filePath = "G:/stream/coffee.html";
		FileInputStream fis = null;
		InputStreamReader isr = null;
		
		try {
			// file - FileInputStream - InputStreamReader - App
			fis = new FileInputStream(filePath);
			isr = new InputStreamReader(fis,"utf-8");
			while(true) {
				int data = isr.read();
				if(data == -1) {
					fis.close();
					isr.close();
					return;
				}
				System.out.print((char)data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				isr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
