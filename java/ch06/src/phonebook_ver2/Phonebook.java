package phonebook_ver2;

public class Phonebook {
	int index = 0;
	PhoneInfo[] infos = new PhoneInfo[2];
	
	void insertData(PhoneInfo info) {
		infos[index] = info;
		index++;
		if(index >= infos.length) {
			// 용량 늘리기
			//System.out.println("용량늘림");
			sizeUp();
		}
	}
	
	void sizeUp() {
		PhoneInfo[] newInfos = new PhoneInfo[infos.length*2];
		System.arraycopy(infos, 0, newInfos, 0, infos.length);
		infos = newInfos;
	}
	
	void searchByName(String name) {
		for(PhoneInfo info : infos) {
			if(info != null && info.name.equals(name)) {
				info.showInfo();
				System.out.println("----조회 완료 ----");
				return;
			}
		}
		System.out.println(name + "님을 찾을 수 없습니다.");
	}
	
	void showAll() {
		for(PhoneInfo info : infos) {
			if(info == null) {
				continue;
			}
			info.showInfo();
		}
	}
}
