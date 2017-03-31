//Oscar Miniet
//12121704
//11H6
//Project1
//Suspicion Calculator

import java.util.Scanner;
import java.lang.Math;
public class SuspicionCalculator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Hello and welcome to the UF suspect suspicion calculator.");
		System.out.print("Please enter the time of the crime: ");
		int time=12345;
		int i=0;
		while (i == 0){
		while (!input.hasNextInt()){					//while loops for input validation
			System.out.println("enter a number");
			input.next();
		}
		int a = input.nextInt();
		if (a >= 0000 && a < 2400 && (a%100) < 60){		//makes sure number is valid military time
			time = a;
			i=1;
		}
		else System.out.println("enter a number that can be read in military time");
		}
		System.out.print("Please enter the latitude of the crime: ");
		double crimelat = 11;
		i = 0;
		while (i == 0){
			while (!input.hasNextDouble()){
				System.out.println("enter a number");
				input.next();
			}
			double a = input.nextDouble();
			if (a >= 0 && a < 10){
				crimelat = a;
				i = 1;
			}
			else System.out.print("enter a number between 0 and 10");
		}
		System.out.print("Please enter the longitude of the crime: ");		//user input stage
		double crimelong = 11;
		i = 0;
		while (i == 0){
			while (!input.hasNextDouble()){
				System.out.println("enter a number");
				input.next();
			}
			double a = input.nextDouble();
			if (a >= 0 && a < 10){
				crimelong = a;
				i = 1;
			}
			else System.out.print("enter a number between 0 and 10");
		}
		System.out.print("Please enter the student's UF ID number: ");
		int id = 111111111;
		i = 0;
		while(i == 0){
			while (!input.hasNextInt()){
				System.out.println("enter a number");
				input.next();
			}
			int a = input.nextInt();
			if (a >= 10000000 && a < 99999999 ){			//ID #s must be 8 digits and can't start with a zero
				id = a;
				i = 1;
			}
			else System.out.print("enter an 8 digit UF ID number");
		}
		System.out.print("Please enter their last timestamp: ");
		int tstamp = 12345;
		i=0;
		while (i == 0){
			while (!input.hasNextInt()){
				System.out.println("enter a number");
				input.next();
			}
			int a = input.nextInt();
			if (a >= 0000 && a < time){
				tstamp = a;
				i=1;
			}
			else System.out.println("enter a number between 0000 and 2400 that is before the time of the crime");
		}
		System.out.print("Please enter the latitude of the student: ");
		double studlat =  11;
		i = 0;
		while (i == 0){
			while (!input.hasNextDouble()){
				System.out.println("enter a number");
				input.next();
			}
			double a = input.nextDouble();
			if (a >= 0 && a < 10){
				studlat = a;
				i = 1;
			}
			else System.out.print("enter a number between 0 and 10");
		}
		System.out.print("Please enter the longitude of the student: ");
		double studlong = 11;
		i = 0;
		while (i == 0){
			while (!input.hasNextDouble()){
				System.out.println("enter a number");
				input.next();
			}
			double a = input.nextDouble();
			if (a >= 0 && a < 10){
				studlong = a;
				i = 1;
			}
			else System.out.print("enter a number between 0 and 10");
		}
		System.out.print("Please enter their heartrate: ");
		int bpm = 0;
		i = 0;
		while(i == 0){
			while (!input.hasNextInt()){
				System.out.println("enter a number");
				input.next();
			}
			int a = input.nextInt();
			if (a > 0){
				bpm = a;
				i = 1;
			}
			else System.out.print("enter an 8 digit UF ID number");
		}
		
		boolean moving;
		String motion;
		if (bpm >= 100){
			moving = true;
			motion = "moving";	//determines whether or not the suspect is moving 
		}						//and sets up string for final output
		else{
			moving = false;
			motion = "sedentary";
		}
		
		boolean safe;
		String safeness = "";
		if ((id % 100) < 50){
			safe = true;
			safeness = "safe";	//determines whether or not the suspect is on the safe list or not
		}						// and sets up string for final output
		else{
			safe = false;
			safeness = "unsafe";
		}
		
		double d;
		d = Math.sqrt(Math.pow((crimelat-studlat),2)+Math.pow((crimelong-studlong),2)); //finds student distance from the crime
		d = d * 10;
		d = Math.round(d);		//rounding stage
		d=d / 10;
		
		int hours = (time / 100) - (tstamp / 100); 		//tdist is the actual time between the crime time and the time stamp
		int tdist = (time - tstamp - 40 * hours);		//since the last two digits of military time can't be between 60-99
		
		
		
		
		
		String suspicion = "";
		if (safe == true){
			if (tdist <= 30 && moving == true && d <= 1){
				suspicion = "Highly Likely";
			}
			else if(tdist <= 60 && moving == true && d <= 1){		//determines likeliness for people on the safe list
				suspicion = "Likely";
			}
			else if(tdist <= 90 && moving == true && d >= 3){
				suspicion = "Unsure";
			}
			else if(tdist <= 120 && moving == false && d >=4){
				suspicion = "Unlikely";
			}
			else suspicion = "Highly Unlikely";
		}
		if (safe == false){											//determines likeliness for people on the unsafe list
			if (tdist <=60 && d <= 1){
				suspicion = "Highly Likely";
			}
			else if(tdist <= 90 && moving == true && d <= 2){
				suspicion = "Likely";
			}
			else if(tdist <= 120 && d >= 2){
				suspicion = "Unsure";
			}
			else if(tdist <= 150 && moving == false && d >= 3){
				suspicion = "Unlikely";
			}
			else suspicion = "Highly Unlikely";
		}
		System.out.println(""); 		//final output
		System.out.println("Student " + id +" who is on the "+ safeness + " list, and was " + d + " block units away, at location ("+ Math.round(studlat)+","+Math.round(studlong)+") at "+  tstamp + " and determined to be "+ motion+" is "+ suspicion+ " to be the Criminal.");
	}

}
