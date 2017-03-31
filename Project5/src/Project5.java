// Oscar Miniet
// 1212-1704
// 11H6
// Project 5
// Create an autograder

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Project5 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String id = "";
		String dicname = "";
		ArrayList<String> dictionary = new ArrayList<String>();
		boolean unfound = true;
		while (unfound == true){
			System.out.println("Please specify the name of the file that contains the dictionary information.");
			dicname = input.nextLine();
			try{
				File dic = new File(dicname+ ".txt");
				if (dic.exists()) System.out.println("File opened successfully!");
				Scanner words = new Scanner(dic);
				while (words.hasNextLine()){
					dictionary.add(words.nextLine());
				}
				unfound = false;
			}catch (FileNotFoundException ab){
				System.out.println("File " + dicname + " cannot found!");
			}
		}
		boolean run = true;
		unfound = true;
		String type = "";
		String name = "";
		int ida;
		String major = "";
		String advisor = "";
		String hsname = "";
		String checking = "";
		String wrongnums = "";
		int wrongs;
		int mult = 0;
		char l;
		boolean misspelled;
		while (run == true){
			unfound = true;
			wrongnums = "";
			while(unfound == true){
				System.out.println("Please specify the ID of the student whose essay will be graded.");
				id = input.nextLine();
				if (!id.equals("Finished")){
				try {
	
					File outfile = new File(id + "_graded.txt");
					if (!outfile.exists()){ 
						outfile.createNewFile();
					}
					PrintWriter writer = new PrintWriter(outfile);
				
				try{
					File file = new File(id+".txt");		//reading from the text file
					if (file.exists()) System.out.println("File opened successfully!");
					Scanner sc = new Scanner(file);
					type = sc.next();
					sc.nextLine();
					name = sc.nextLine();
					ida = sc.nextInt();
					sc.nextLine();
					if (type.equalsIgnoreCase("Graduate")){
						mult = 5;
						major = sc.nextLine();
						advisor = sc.nextLine();
						GraduateStudent student
							= new GraduateStudent(name, ida, major, advisor);
						//System.out.println(student.toString());
						writer.println(student.toString());
					}
					else if(type.equalsIgnoreCase("Undergraduate")){
						mult = 3;
						major = sc.nextLine();
						UndergraduateStudent student
							= new UndergraduateStudent(name, ida, major);
						//System.out.println(student.toString());
						writer.println(student.toString());
					}
					else if(type.equalsIgnoreCase("HighSchool")){
						mult = 1;
						hsname = sc.nextLine();
						HighSchoolStudent student
							= new HighSchoolStudent(name, ida, hsname);
						//System.out.println(student.toString());
						writer.println(student.toString());
					}
					wrongs = 0;
					while (sc.hasNext()){
						misspelled = true;
						checking = sc.next();
						l = checking.charAt(checking.length()-1);
						if (l == '.' || l == ',' || l == '?' || l == '!' || l == ':' || l == ';'){
							checking = checking.substring(0,checking.length()-1);
						}
						for (int i = 0; i < dictionary.size();i++){
							if(checking.equalsIgnoreCase(dictionary.get(i))){
								misspelled = false;
								break;
							}
						}
						if(misspelled == true){
							wrongs++;
							wrongnums = wrongnums + "(" + wrongs + ") " + checking + "\n";
						}
					}
					int score = 100 - (mult*wrongs);
					writer.println("Received a score of " + score + " with " + wrongs + " misspelled words:");
					//System.out.println("Received a score of " + score + " with " + wrongs + " misspelled words");
					writer.println(wrongnums);
					//System.out.println(wrongnums);
					unfound = false;
					sc.close();
		        } 
				catch(FileNotFoundException ex){
					System.out.println("File " + id +" cannot be found!");
		        }
				writer.close();
				} 
				catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				catch(IOException e){
					e.printStackTrace();
				}
				}
				else{
					run = false;
					break;
				}
			}
		}
		//System.out.println(essay);
	}

}
