import java.util.ArrayList;
import java.util.List;
import java.lang.NullPointerException;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
public class ContactManager{
	private static String spacer = "?\\|"; //This is a string that will act as a space within the save file, enabling easyparsing of the data. This could lead to conflicts with consumers using the same characters in their contact info. This should currently appear as ?\| in the text file. 
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
					parseFile(saveFile);
					Thread.sleep(1000);
				}
				catch(Exception e){
					System.out.println("Oh oh! An error occurred while importing the save file! Please contact the developer.");
				}
			}
		}
		
	}
	public static void parseFile(File save){
		if(save == null)throw new NullPointerException("Oh no! It looks like your contacts list isn't in a valid file. Please contact the developer.");
		Scanner file = new Scanner(save);
		while(Scanner.hasNext()){
			List<String> toAdd = new ArrayList<String>();
			String items = file.next();
			toAdd.add(items);
			for(int i = 0; i<items.length(); i++){
				String rawIn = file.next();
				String transmutedRawIn = rawIn.replaceAll(spacer," ");
				toAdd.add(transmutedRawIn);
			}
		}
	}
}
