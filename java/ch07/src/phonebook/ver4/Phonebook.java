package phonebook.ver4;

import java.util.Arrays;

public class Phonebook {
	private int index = 0;
	private PhoneInfo[] infos = new PhoneInfo[2];
	private int sIndex = 0;
	private PhoneInfoSocial[] socialInfos = new PhoneInfoSocial[2];
	private int uIndex = 0;
	private PhoneInfoUniv[] univInfos = new PhoneInfoUniv[2];
	
	public void insertData(PhoneInfo info) {
		infos[index] = info;
		index++;
		if(index >= infos.length) {
			// 용량 늘리기
			//System.out.println("용량늘림");
			sizeUp();
		}
	}
	
	public void insertSocial(PhoneInfoSocial info) {
		socialInfos[sIndex] = info;
		sIndex++;
		if(sIndex >= socialInfos.length) {
			sSizeUp();
		}
	}
	
	public void insertUniv(PhoneInfoUniv info) {
		univInfos[uIndex] = info;
		uIndex++;
		if(uIndex >= univInfos.length) {
			uSizeUp();
		}
	}
	
	public void sizeUp() {
		PhoneInfo[] newInfos = new PhoneInfo[infos.length*2];
		System.arraycopy(infos, 0, newInfos, 0, infos.length);
		infos = newInfos;
	}
	
	public void sSizeUp() {
		PhoneInfoSocial[] newInfos = new PhoneInfoSocial[socialInfos.length*2];
		System.arraycopy(socialInfos, 0, newInfos, 0, socialInfos.length);
		socialInfos = newInfos;
	}
	
	public void uSizeUp() {
		PhoneInfoUniv[] newInfos = new PhoneInfoUniv[univInfos.length*2];
		System.arraycopy(univInfos, 0, newInfos, 0, univInfos.length);
		univInfos = newInfos;
	}
	
	public void searchByName(String name) {
		for(PhoneInfoSocial sInfo : socialInfos) {
			if(sInfo != null && sInfo.getName().equals(name)) {
				sInfo.showInfo();
				System.out.println("----조회 완료----");
				return;
			}
		}
		for(PhoneInfoUniv uInfo : univInfos) {
			if(uInfo != null && uInfo.getName().equals(name)) {
				uInfo.showInfo();
				System.out.println("----조회 완료----");
				return;
			}
		}
		for(PhoneInfo info : infos) {
			if(info != null && info.getName().equals(name)) {
				info.showInfo();
				System.out.println("----조회 완료 ----");
				return;
			}
		}
		System.out.println(name + "님을 찾을 수 없습니다.");
	}
	
	public void showAll() {
		for(PhoneInfo info : infos) {
			if(info == null) {
				continue;
			}
			info.showInfo();
		}
	}

	@Override
	public String toString() {
		return "Phonebook [index=" + index + ", infos=" + Arrays.toString(infos) + "]";
	}
	
}
