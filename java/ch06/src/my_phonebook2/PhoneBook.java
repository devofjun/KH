package my_phonebook2;

public class PhoneBook {
	PhoneInfo[] infos = new PhoneInfo[5];
	int idx = 0;
	
	void insertData(PhoneInfo in) {
		infos[idx++] = in;
		if(idx>=infos.length) {
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
			if(name.equals(info.getName())) {
				System.out.println("찾았습니다.");
				info.showInfo();
				return;
			}
		}
		System.out.println("찾지못했습니다.");
	}
	
	void showAll() {
		for(int i=0; i<idx; ++i) {
			infos[i].showInfo();
		}
	}
}
