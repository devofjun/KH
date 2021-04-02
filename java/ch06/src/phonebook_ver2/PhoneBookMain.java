package phonebook_ver2;

public class PhoneBookMain {
	public static void main(String[] args) {
		Phonebook book = new Phonebook();
		outter:
		while(true) {
			int choice = MenuViewer.showStartMenu();
			switch(choice) {
			case MenuViewer.INPUT:
				PhoneInfo info = MenuViewer.getPhoneInfo();
				book.insertData(info);
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
