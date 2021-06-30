package com.kh.sample02.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class MyFileUploadUtil {
	//uploadPath는 팀작업할때 서버를 두고 하면된다?
	public static String uploadFile(String uploadPath, String originalFilename, byte[] fileData) throws Exception{
		// uuid_noname01.png
		String datePath = calcPath(uploadPath);
		UUID uuid = UUID.randomUUID(); // 중복되지 않는 고유한 값
		// D:/upload/2021/6/30/uuid_noname.png
		String filePath = datePath + "/" + uuid + "_" + originalFilename;
		System.out.println("filePath: " + filePath);
		
		File target = new File(filePath);
		FileCopyUtils.copy(fileData, target); // 바이트 배열을 복사한다.
		return filePath;
	}
	
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);
		
		String dateString = year + "/" + month + "/" + date; 
		String datePath =  uploadPath + "/" + dateString;
		// -> D:/upload/
		System.out.println("datePath: " + datePath);
		
		File f = new File(datePath);
		if(!f.exists()) {
			f.mkdirs();
		}
		return datePath;
	}
}
