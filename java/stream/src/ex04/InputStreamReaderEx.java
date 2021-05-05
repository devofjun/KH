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
			// file -> FileInputStream -> InputStreamReader -> App
			fis = new FileInputStream(filePath); // 데이터를 읽어올 파일 생성
			isr = new InputStreamReader(fis,"utf-8"); // 읽어온 데이터와  문자형식(CharSet)을 선택
			while(true) {
				int data = isr.read(); // InputStreamReader로 부터 '한글자'를 읽어온다.
				if(data == -1) { // 파일의 끝이라면 종료
					fis.close();
					isr.close();
					return;
				}
				System.out.print((char)data); // 출력
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // 중간에 오류가 나서 catch로 넘어갔을 경우에도 자원을 해제하기 위한 finally
			try {
				fis.close();
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
