package ex06;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx {
	public static void main(String[] args) {
		String fileName = "G:/stream/test.txt";
		
		File f = new File(fileName);
		
		// 파일인지 디렉토리인지
		if(f.isFile()) {
			System.out.println("파일입니다.");
		} else {
			System.out.println("디렉토리입니다.");
		}
		//파일명
		System.out.println("파일명: " + f.getName());
		//경로명
		System.out.println("경로명: " + f.getPath());
		//상위폴더명
		System.out.println("상위폴더명: " + f.getParent());
		
		//파일 목록 얻기 = 리눅스의 li
		f = new File("C:/windows");
		File[] files = f.listFiles();
		for(File afile : files) {
			// 파일명
			String fName = afile.getName();
			
			// 파일인지 디렉토리인지
			String fileOrDir = "";
			if(afile.isFile()) {
				fileOrDir = "f";
			} else {
				fileOrDir = "D";
			}
			
			// 파일의 크기
			long fSize = afile.length();
			
			// 최종 수정일
			long time = afile.lastModified();
			// 자주 쓰이게 될 날짜 포멧?
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 DD일 HH시 mm분 ss초");
			Date date = new Date(time); // Date는 java.util에 있는걸 써야한다.
			String formattedDate = sdf.format(date);
			// 이름과 파일 디렉토리 구분
			System.out.print(fName + "\t" + fileOrDir);
			if(afile.isFile()) {
				System.out.println("\t파일크기:"+fSize+"(bytes)\t"+formattedDate);
			}
			System.out.println();
		}
		
		// 폴더 생성하는 법
		f = new File("G:/stream/java");
		// 해당 폴더가 존재하지 않으면 폴더 만들기
		if(!f.exists()) {
			f.mkdir();
		}
		
	}
}
