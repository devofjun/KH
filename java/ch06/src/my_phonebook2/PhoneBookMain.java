package my_phonebook2;

public class PhoneBookMain {
	public static void main(String[] args) {
		PhoneBook pBook = new PhoneBook();
		outter:
		while(true) {
			int choice = MenuViewer.showStartMenu();
			switch(choice) {
			case MenuViewer.INPUT :
				pBook.insertData(MenuViewer.getPhoneInfo());
				break;
			case MenuViewer.SEARCH :
				pBook.searchByName(MenuViewer.getSearchName());
				break;
			case MenuViewer.EXIT :
				MenuViewer.showExitMessage();
				break outter;
			case MenuViewer.ALL :
				pBook.showAll();
				break;
			default:
				System.out.println("잘못입력함 다시 입력하시오.");
				break;
			}			
		}
	}
}
