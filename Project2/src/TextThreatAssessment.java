// Oscar Miniet
// 12121704
// 11H6
// Project 2
// reads text from a file and checks for key words

import java.io.File;
import java.util.Scanner;

public class TextThreatAssessment {
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		
		boolean cont = true;
		while (cont == true) {
			String repeat = "";
			System.out.print("Enter the UF ID of the person who wrote the texts: ");
			int id = 0;
			String number = input.next();		//takes input as a string
			for (int x=0;x<number.length();x ++){ //checks if all the indexes of the string are numbers
				if (!(number.charAt(x) >= '0' && number.charAt(x) <= '9')){
					System.out.println("Error: UFID must be a number. Now Exiting.");
					System.exit(0);
				}
			}
			if (number.charAt(0) == '0'){
				System.out.println("Error: UFID must not begin with a zero. Now Exiting.");
				System.exit(0);					//checks if number begins with a 0
			}
			else {
				int value = Integer.parseInt(number);
				if (value >=10000000 && value <= 99999999){
					id = value;					//changes the entry from String to int and then checks if its 8 digits
				}
				else {
					System.out.println("Error: UFID must be 8 digits. Now Exiting.");
					System.exit(0);
				}
			}
			System.out.println("Opening file: " + id + ".txt");
			System.out.print("Enter the word (or phrase) of interest: ");
			String key = input.next();
			
			
			String encryptedString = "";
	        try
	         {
	        	File file = new File(id+".txt");		//reading from the text file
	        	Scanner sc = new Scanner(file);
	        	while (sc.hasNextLine())
	        		{
	        		encryptedString+=sc.nextLine();
	        		}
	        	sc.close();
	         } catch(Exception ex)
	        {
	        	 ex.printStackTrace();
	        }
	        String newString = "";
	        int x =encryptedString.length();		
	        for (int i = 0; i < x; i++){			//reverses the string
	        	newString = encryptedString.charAt(0) + newString;
	        	encryptedString = encryptedString.substring(1, encryptedString.length());
	        }
	        
	        String finalString = "";
	        for (int i = 0; i < newString.length()/2; i++){		//deletes every second character
	        	finalString = finalString + newString.charAt((i*2)+1);
	        }
	        
	        int count = 0;
	        for (int i = 0; i < (finalString.length()-key.length()); i++){	//checks and counts the appearance of the key word/phrase
	        	String checker = finalString.substring(i, i + key.length());
	        	if (checker.equalsIgnoreCase(key)){
	        		count = count + 1;
	        	}
	        }
	        
	        String threat  = "";
	        if (count <= 1) threat = "Safe";
	        else if (count <= 2) threat = "Somewhat Threatening"; //sets up the string for final output
	        else if (count <= 3) threat = "Threatening";
	        else threat = "Highly Threatening";
	        
	        System.out.println("The word " + key + " was found " +  count +" time(s)");
	        System.out.println("Messages from student " + id + " were found to be: " + threat);
	        
	        while (!(repeat.equals("y") || repeat.equals("n"))){
	        	System.out.print("Press (y) to continue or (n) to exit. ");
		        repeat = input.next();
		        if (repeat.equals("y")) cont = true;
		        else if (repeat.equalsIgnoreCase("n")) cont = false;
	        }
		}
	}
}
