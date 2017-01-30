import java.io.File;
import java.util.Scanner;
public class ContactManager{
	public static void main(String[] args){
		File saveFile = new File("contactManager.PMARINA");
		boolean saveFileExists = (saveFile.exists() && saveFile.isFile());
		Scanner sc = new Scanner(System.in);
		if(!saveFileExists){
			System.out.println("The system has detected an existing save file. Would you like to import the file or would you like to start with an empty ContactManager");
			String useSave = sc.next();
			if(useSave.lower().equals("y") || useSave.lower().equals("yes"){
				System.out.println("Importing save file");
				try{
					Thread.sleep(1000);
				}
				catch(Exception e){
					System.out.println("Oh oh! An error occurred while importing the save file! Please contact the developer.");
				}
			}
		}
		
	}
}
