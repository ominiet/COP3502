//Oscar Miniet
//12121704
//11H6
//Project3 
//Some Harry potter thing

import java.util.Scanner;	
import java.util.Arrays;
														
public class DiagonAlleyGuide {							
	public static void mainMenu(){
		System.out.println("\nMain menu:");				
		System.out.println("1. Gringotts Bank");
		System.out.println("2. List of Supplies");
		System.out.println("3. Shoppes");
		System.out.println("4. Leave");
		System.out.println("");
		System.out.print("Selection: ");
	}
	public static void gringottsMenu(){
		System.out.println("Gringotts Bank");
		System.out.println("1. Exchange Money");
		System.out.println("2. Check Balance");
		System.out.println("3. Exit");
		System.out.println("");
		System.out.print("Selection: ");
	}
	public static void shoppes(){
		System.out.println("Shoppes");
		System.out.println("1. Broomstix");
		System.out.println("2. Second-Hand Robes");
		System.out.println("3. Olivanders");
		System.out.println("4. Flourish and Blotts");
		System.out.println("5. Potage's Cauldron Shop");
		System.out.println("6. Exit");
		System.out.println("");
		System.out.print("Selection: ");
	}
	public static int exchangeGalleons1(double USD){		//unneeded method
		int galleons = 0;
		int knuts = (int)(USD * 10);
		System.out.println("This translates to "+ knuts + " knuts");
		int sickle = knuts/29;
		knuts = knuts%29;
		galleons = sickle / 17;
		sickle = sickle % 17;
		System.out.println(galleons + "\n" + sickle + "\n" + knuts);
		return galleons;
	}
	public static int exchangeGalleons(double USD){
		int galleons = (int)(USD * 10 / 29 / 17);
		return galleons;
	}
	public static int exchangeSickles(double USD){
		int sickles = (int)(USD * 10 / 29 % 17);
		return sickles;
	}
	public static int exchangeKnuts(double USD){
		int knuts = (int)(USD * 10 % 29);
		return knuts;
	}
	public static void balance(int[] money){ //edited
		int galleons = money[0];	//added
		int sickles = money[1];		//added
		int knuts = money[2];		//added
		String gallString = " Galleons, ",sickString = " Sickles, and ",knutString = " Knuts.";
		if (galleons == 1){
			gallString = " Galleon, ";
		}
		if (sickles == 1){
			sickString = " Sickle, and ";
		}
		if (knuts == 1){
			knutString= " Knut.";
		}
		System.out.println("\nYou have " + galleons + gallString + sickles + sickString + knuts + knutString);
		System.out.println("");
	}
	public static boolean enoughMoney(int galleon, int sickle, int knut, int cost){
		boolean enough;
		int balanceKnuts = (galleon * 493) + (sickle * 29) + knut;
		if (balanceKnuts < cost){
			enough = false;
		}
		else {
			enough = true;
		}
		return enough;
	}
	public static int[] buy(int[] umoney, int sgal, int ssick, int sknut){ //edited
		int ugal = umoney[0];	//added
		int usick = umoney[1];	//added
		int uknut = umoney[2];	//added
		int[] monleft = new int[3];
		monleft[0] = ugal;
		monleft[1] = usick;
		monleft[2] = uknut;
		if (enoughMoney(ugal, usick, uknut, ((sgal*493)+(ssick*29)+ sknut)) == true){//makes sure user has enough money
			if (sknut>uknut){
				usick--;
				uknut = uknut + 29; 
			}
			if (ssick> usick){
				ugal--;
				usick = usick + 17;
			}
			monleft[1]=usick-ssick;
			monleft[2]=uknut-sknut;
			monleft[0]=ugal-sgal; //if user has enough money ugal will always be >= sgal
			
		}
		
		return monleft;
	}
	public static void main(String[] args){
		int[] monLeft = new int[3];
		Scanner input = new Scanner(System.in);
		boolean run = true;
		int choice;				//initializing variables  and arrays for use in loops
		int gringottschoice;
		int shoppeschoice;
		String[] needList = new String[7];
		needList[0] = "Broom";
		needList[1] = "School robes";
		needList[2] = "Wand";
		needList[3] = "The Standard Book of Spells";
		needList[4] = "A History of Magic";
		needList[5] = "Magical Drafts and Potions";
		needList[6] = "Cauldron";
		String[] haveList = new String[7];
		for (int x = 0; x < haveList.length; x++){
			haveList[x] = "0";
		}
		System.out.println("Welcome to Diagon Alley!");	//added
		while(run == true){
			mainMenu();
			choice = input.nextInt();
			System.out.println("");
			
			if (choice == 1){
				boolean gringott = true;
				while (gringott == true){
					gringottsMenu();
					gringottschoice = input.nextInt();
					if (gringottschoice == 1){
						System.out.println("\nHow much money would you like to exchange?");
						System.out.print("USD: ");
						double convert = input.nextDouble();
						if (convert >= 0){
							monLeft[0]= monLeft[0] + exchangeGalleons(convert);	//edited
							monLeft[1]= monLeft[1] + exchangeSickles(convert);	//edited
							monLeft[2]= monLeft[2] + exchangeKnuts(convert);	//edited
							System.out.println("\nTransaction Complete!\n");
						}
						else{
							System.out.println("\nTransaction failed!\nInput cannot be negative!\n");
						}
					}
					else if(gringottschoice == 2){
						System.out.println("");
						balance(monLeft);
					}
					else if(gringottschoice == 3){
						gringott = false;
					}
					else{
						System.out.println("Invalid entry!");
					}
				}
			}
			else if(choice == 2){
				System.out.println("Inventory: \n");
				for (int i = 0; i < haveList.length;i++){
					if(!(haveList[i].equals("0"))){
						System.out.println(haveList[i]);
					}
					
				}
				System.out.println("");
				System.out.println("Need: \n");
				for (int i = 0; i < needList.length;i++){
					if (!(needList[i].equals("0"))){
						System.out.println(needList[i]);
					}
				}
				System.out.println("");

			}
			else if(choice == 3){
				boolean shoppes = true;
				boolean sameshop = true;
				while(shoppes == true){
					int buyChoice;
					shoppes();
					shoppeschoice = input.nextInt();
					System.out.println("");
					if (shoppeschoice == 1){
						sameshop= true;
						while (sameshop==true){		
							System.out.println("Broomstix");
							System.out.println("1. Buy Broom for 1 Galleon");
							System.out.println("2. Exit\n");
							System.out.print("Selection: ");
							buyChoice = input.nextInt();
							System.out.println("");
							if (buyChoice == 1){
								if(haveList[0].equals("0")){
									if (!Arrays.equals(monLeft, buy(monLeft,1,0,0))){//added
										monLeft=buy(monLeft,1,0,0);	//edited
										haveList[0]=needList[0];
										needList[0]="0";
										System.out.println("Transaction Successful!\n");
									}
									else{//moved from method
										System.out.println("Transaction Failed!");
										System.out.println("You don't have enough money!");
									}
								}
								else System.out.println("Transaction Failed\nYou already have that item!\n");
							}
							else if(buyChoice==2){
								sameshop=false;
							}
							else System.out.println("Invalid entry!");
						}
					}
					else if (shoppeschoice == 2){
						sameshop=true;
						while(sameshop==true){
							System.out.println("Second-Hand Robes");
							System.out.println("1. Buy School Robes for 12 sickles");//edited Robes
							System.out.println("2. Exit\n");
							System.out.print("Selection: ");
							buyChoice = input.nextInt();
							System.out.println("");
							if (buyChoice == 1){
								if(haveList[1].equals("0")){
									if (!Arrays.equals(monLeft, buy(monLeft,0,12,0))){	//added
										monLeft=buy(monLeft,0,12,0);	// edited
										haveList[1]=needList[1];
										needList[1]="0";
										System.out.println("Transaction Successful!\n");
									}
									else{//moved from method
										System.out.println("Transaction Failed!");
										System.out.println("You don't have enough money!");
									}
								}
								else System.out.println("Transaction Failed\nYou already have that item!\n");
							}
							else if(buyChoice==2){
								sameshop=false;
							}
							else System.out.println("Invalid entry!");
						}
					}
					else if (shoppeschoice == 3){
						sameshop=true;
						while(sameshop==true){
							System.out.println("Olivanders");
							System.out.println("1. Buy Wand for 7 sickles");
							System.out.println("2. Exit\n");
							System.out.print("Selection: ");
							buyChoice = input.nextInt();
							System.out.println("");
							if (buyChoice == 1){
								if(haveList[2].equals("0")){
									if(!Arrays.equals(monLeft, buy(monLeft,0,7,0))){	//added
										monLeft=buy(monLeft,0,7,0);
										haveList[2]=needList[2];
										needList[2]="0";
										System.out.println("Transaction Successful!\n");
									}
									else{//moved from method
										System.out.println("Transaction Failed!");
										System.out.println("You don't have enough money!");
									}
								}
								else System.out.println("Transaction Failed\nYou already have that item!\n");
							}
							else if(buyChoice==2){
								sameshop = false;
							}
							else System.out.println("Invalid entry!");
						}
					}
					else if (shoppeschoice == 4){
						sameshop=true;
						while (sameshop == true){
							System.out.println("Flourish and Blotts");
							System.out.println("1. Buy The Standard Book of Spells for 5 Sickles");
							System.out.println("2. Buy History of Magic for 3 Sickles and 12 Knuts");
							System.out.println("3. Buy Magical Drafts and Potions for 27 Knuts");
							System.out.println("4. Exit\n");
							System.out.print("Selection: ");
							buyChoice = input.nextInt();
							System.out.println("");
							if (buyChoice == 1){
								if(haveList[3].equals("0")){
									if (!Arrays.equals(monLeft, buy(monLeft,0,5,0))){//added
										monLeft = buy(monLeft,0,5,0);	//edited
										haveList[3]=needList[3];
										needList[3]="0";
										System.out.println("Transaction Successful!\n");
									}
									else{//moved from method
										System.out.println("Transaction Failed!");
										System.out.println("You don't have enough money!");
									}
								}
								else System.out.println("Transaction Failed\nYou already have that item!\n");
							}
							else if (buyChoice == 2){
								if(haveList[4].equals("0")){
									if (!Arrays.equals(monLeft, buy(monLeft,0,3,12))){//added
										monLeft=buy(monLeft,0,3,12);		//edited
										haveList[4]=needList[4];
										needList[4]="0";
										System.out.println("Transaction Successful!\n");
									}
									else{//moved from method
										System.out.println("Transaction Failed!");
										System.out.println("You don't have enough money!");
									}
								}
								else System.out.println("Transaction Failed\nYou already have that item!\n");
							}
							else if (buyChoice == 3){
								if(haveList[5].equals("0")){
									if (!Arrays.equals(monLeft, buy(monLeft,0,0,27))){//added
										monLeft = buy(monLeft,0,0,27);	//edited
										haveList[5]=needList[5];
										needList[5]="0";
										System.out.println("Transaction Successful!\n");
									}
									else{//moved from method
										System.out.println("Transaction Failed!");
										System.out.println("You don't have enough money!");
									}
								}
								else System.out.println("Transaction Failed\nYou already have that item!\n");
							}
							else if (buyChoice == 4){
								sameshop=false;
							}
							else{
								System.out.println("Invalid Entry!");
							}
						}
					}
					else if (shoppeschoice == 5){
						sameshop= true;
						while (sameshop == true){
							System.out.println("Potage's Cauldron Shop");
							System.out.println("1. Buy Cauldron for 10 Sickles");
							System.out.println("2. Exit\n");
							System.out.print("Selection: ");
							buyChoice = input.nextInt();
							System.out.println("");
							if (buyChoice == 1){
								if(haveList[6].equals("0")){		//edited
									if (!Arrays.equals(monLeft, buy(monLeft,0,10,0))){//added
										monLeft = buy(monLeft,0,10,0);	//edited
										haveList[6]=needList[6];
										needList[6]="0";
										System.out.println("Transaction Successful!\n");
									}
									else{//moved from method
										System.out.println("Transaction Failed!");
										System.out.println("You don't have enough money!");
									}
								}
								else System.out.println("Transaction Failed\nYou already have that item!\n");
							}
							else if(buyChoice == 2){
								sameshop=false;
							}
							else System.out.println("Invalid entry!");
						}
					}
					else if (shoppeschoice == 6){
						shoppes = false;
					}
					else{
						System.out.println("Invalid Entry!");
					}
				}
			}
			else if(choice == 4){
				int outputcheck = 0;
				for (int i =0;i< needList.length;i++)
					if (!(needList[i].equals("0"))){
						outputcheck++;
					}
				if (outputcheck == 0){
					System.out.println("Have a nice day!");
					run = false;
				}
				else if(outputcheck < 7){
					System.out.println("You are missing some items!");
					System.out.println("Missing:");
					for (int i = 0; i <needList.length; i++){	//added
						if (!needList[i].equals("0")){			//added
							System.out.println(needList[i]);	//added
						}
					}
					run = false;
				}
				else if(outputcheck == 7){
					System.out.println("You have no supplies!");
					run = false;
					
				}
				
			}
			else{
				System.out.println("Invalid entry!");
			}
		}
		
	}
}