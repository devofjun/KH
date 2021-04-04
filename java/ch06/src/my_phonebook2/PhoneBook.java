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
	
	void showAll() {
		for(int i=0; i<idx; ++i) {
			infos[i].showInfo();
		}
	}
}
