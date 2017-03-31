//Oscar Miniet
//12121704
//11H6
//Lab 8 
//Creates Pokemon object

public class Pokemon {
	String species = "";
	int attack;
	int defense;
	int speed;
	
	public String getSpecies(){
		return species;
	}
	public void setSpecies(String spc){		//getters and setters
		species = spc;
	}
	public int getAttack(){
		return attack;
	}
	public void setAttack(int atk){
		attack = atk;
	}
	public int getDefense(){
		return defense;
	}
	public void setDefense(int def){
		defense = def;
	}
	public int getSpeed(){
		return speed;
	}
	public void setSpeed(int spd){
		speed = spd;
	}
	public void grow(int boost){
		attack = attack + boost;
	}
	public void harden(int boost){
		defense = defense + boost;
	}
	public void haste(int boost){
		speed = speed + boost;
	}
	public Pokemon(String species, int attack, int defense, int speed){		//constructer for pokemon object
		this.species= species;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
	}
}
