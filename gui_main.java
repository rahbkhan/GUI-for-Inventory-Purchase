//package FootballStore;

import java.text.ParseException;

//import java.text.ParseException;

//import guiV2.login;
//import guiV2.launchPage;
public class gui_main {

	public static void main(String[] args) {
		// new login();
		// new homepage();

		try {
			new launchPage();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("This can not be opened");
		}

	}

}
