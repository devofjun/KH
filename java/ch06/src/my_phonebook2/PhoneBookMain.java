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
				pBook.showAll(); // testing
				break;
			case 2:
				break;
			case 3:
				break outter;
			}			
		}
	}
}
