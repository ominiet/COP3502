//Oscar Miniet
//12121704
//11H6
//Lab 8 
//Implements the Pokemon and Pokedex objects

import java.util.Scanner;
public class Project4 {
	public static void  Menu(){		//method for Menu to remove clutter in main method
		System.out.println("");
		System.out.println("1. List Pokemon");
		System.out.println("2. Add Pokemon");
		System.out.println("3. Check a Pokemon's Stats");
		System.out.println("4. Sort pokemon");
		System.out.println("5. Exit");
		System.out.println("");
		System.out.print("What would you like to do? ");
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		int size = 0;
		while (size == 0){
			System.out.println("Welcome to your new Pokedex!");
			System.out.print("How many Pokemon are in your region?: ");		//input validation for Pokedex size
			while (!input.hasNextInt()){
				input.nextLine();
				System.out.println("\nThat's not a valid input choice. Try again!\n");
				System.out.println("Welcome to your new Pokedex!");
				System.out.print("How many Pokemon are in your region?: ");
			}
			size = input.nextInt();
			if (size > 5 || size < 1){
				size = 0;
				System.out.println("\nThat's not a valid input choice. Try again!\n");
			}
		}
		Pokedex pokedex = new Pokedex(size);
		System.out.println("\nYour new Pokedex can hold " + size + " pokemon. Let's start using it");
		String choice = "";
		Pokemon pkmn;
		String name = "";
		int attack;
		int defense;
		int speed;
		boolean run = true;
		while (run == true){				//setup and variable initialization for menu
			Menu();
			choice = input.next();
			if (choice.equals("1")){		//list Pokemon option
				System.out.println("");
				pokedex.listPokemon();
			}
			else if (choice.equals("2")){	//add pokemon option and assigning stats
				System.out.print("\nPlease enter the Pokemon's name: ");
				name = input.next();
				attack = (name.length() * 4) +2;
				defense = (name.length() * 2) +7;
				speed = (name.length() * 3) + 5;
				pkmn = new Pokemon(name, attack, defense, speed);
				pokedex.addPokemon(pkmn);
			}
			else if (choice.equals("3")){	//checking for a Pokemon to display stats
				System.out.print("\nPlease enter the Pokemon of interest: ");
				name = input.next();
				pokedex.checkStats(name);
			}
			else if (choice.equals("4")){	//sorts pokemon
					pokedex.sortPokemon();
			}
			else if (choice.equals("5")){	//ends loop and therefore program if picked
				run = false;
			}
			else {							//returns to top of loop if an invalid choice was picked
				System.out.println("\nThat's not a valid input choice. Try again!");//added word "input"
			}
		}
		
	}
}
