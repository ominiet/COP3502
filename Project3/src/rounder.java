import java.util.Arrays;
public class rounder {
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
		monLeft[0] = 0;//added
		monLeft[1] = 0;//added
		monLeft[2] = 0;//added
		int[] test = buy(monLeft,1,0,0);
		for (int i = 0; i <test.length;i++){
			System.out.println(test[i]);
		}
		if (Arrays.equals(monLeft, test)){
			System.out.println("transaction failed");
		}
		else{
			System.out.println("transactioncomplete");
		}
	}

}
