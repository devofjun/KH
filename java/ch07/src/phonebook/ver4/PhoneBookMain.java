package phonebook.ver4;

public class PhoneBookMain {
	public static void main(String[] args) {
		Phonebook book = new Phonebook();
		outter:
		while(true) {
			int choice = MenuViewer.showStartMenu();
			switch(choice) {
			case MenuViewer.INPUT:
				choice = MenuViewer.showSubMenu();
				if(choice==1) { //사회
					book.insertSocial(MenuViewer.getSocialInfo());
				} else if(choice==2) { //대학
					book.insertUniv(MenuViewer.getUnivInfo());
				} else if(choice==3) { //일반
					PhoneInfo info = MenuViewer.getPhoneInfo();
					book.insertData(info);
				} else {
					System.out.println("잘못입력함.");	
				}
				//book.showAll();
				break;
			case MenuViewer.SEARCH:
				String name = MenuViewer.getSearchName();
				book.searchByName(name);
				break;
			case MenuViewer.EXIT:
				MenuViewer.showExitMessage();
				break outter;
			default :
				System.out.println("잘못입력");
				break;
			}			
		}
	}
}
