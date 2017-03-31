//Oscar Miniet
//12121704
//11H6
//Lab 8 
//creates a pokedex from the created pokemon objects

public class Pokedex {
	int size;
	Pokemon[] dex;
	
	public void listPokemon(){
		for (int i = 0; i < size; i++){	//simply lists the species of the indices of the array.
			if (dex[i] != null){
				System.out.println((i+1) + ". " + dex[i].getSpecies());//deleted printing of unfound pokemon
			}
		}
	}
	public void addPokemon(Pokemon pkm){
		int nullcount;
		nullcount = 0;
		for (int i = 0; i < size; i++){ //checks to see if there is any null indices
			if (dex[i] == null){
				nullcount++;
			}
		}
		if (nullcount == 0){			//if there are no null indices then the array must be full
			System.out.println("Your Pokedex is already holding the max amount!");
		}
		else {
			for (int i = 0; i < size; i++ ){
				if(dex[i] != null){
					if (pkm.getSpecies().equals(dex[i].getSpecies())){
						System.out.println("Your Pokedex is already storing that Pokemon!");
						break;
					}
				}		//checks if the pokemon is already in the array
				else if(dex[i] == null){
					dex[i] = pkm;
					break;
				}		//sets the Pokemon to the next open index if it is not already found and breaks loop when set
			}
		}
	}
	public void checkStats(String pkm_nm){
		int printed = 0;
		for (int i = 0; i < size; i++){
			if (dex[i] != null){		//checks all non-null indices of the array if there is a match with the input species
				if (pkm_nm.equalsIgnoreCase(dex[i].getSpecies())){
					System.out.println("\nThe stats for " + dex[i].getSpecies() + " are:");
					System.out.println("Attack: " + dex[i].getAttack());
					System.out.println("Defense: " + dex[i].getDefense());
					System.out.println("Speed: " + dex[i].getSpeed());
					printed = 1;
				}
			}
		}
		if (printed == 0){
			System.out.println("\nThe Pokemon could not be found!");
		}
	}
	public void sortPokemon() {
		int i,j;
		int swapping = 0;
		Pokemon mid;
		int checking = 0;
		for (i = 0; i < dex.length;i++){	//added to prevent NullPointer Exception
			if (dex[i] != null){
				checking ++;
			}
		}
		for (i = 0; i < checking; i++){		//works through each index swapping the next alphabetically ordered species name with
			swapping = i;						//the current index
			for (j = i+1; j < checking; j++){
				if (dex[swapping].getSpecies().compareToIgnoreCase(dex[j].getSpecies()) > 0){
				swapping = j;	
				}
			}
			if (swapping != i){
				mid = dex[i];
				dex[i] = dex[swapping];
				dex[swapping] = mid;
			}
		}
	}
	public Pokedex(int size){					//constructor for Pokedex object
		this.size = size;
		this.dex = new Pokemon[size];
	}
}
