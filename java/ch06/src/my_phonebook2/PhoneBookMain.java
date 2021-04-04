package my_phonebook2;

public class PhoneBookMain {
	public static void main(String[] args) {
		MenuViewer menu = new MenuViewer();
		PhoneBook pBook = new PhoneBook();
		outter:
		while(true) {
			int choice = menu.showStartMenu();
			switch(choice) {
			case 1:
				pBook.insertData(menu.getPhoneInfo());
				System.out.println("----입력완료----");
				break;
			case 2:
				pBook.searchByName(menu.getSearchName());
				break;
			case 3:
				menu.showExitMessage();
				break outter;
			case 4:
				pBook.showAll();
				break;
			default:
				System.out.println("잘못입력함 다시 입력하시오.");
				break;
			}			
		}
	}
}
