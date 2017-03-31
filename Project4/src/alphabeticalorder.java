
public class alphabeticalorder {
	public static void swap(String str1, String str2){
		String mid = str1;
		str1 = str2;
		str2 = mid;
	}
	public static void main(String[] args){
		/*String str1 = "abcd";
		String str2 = "bcde";
		String str3 = "c";
		String str4 = "abcd";
		String str5 = "abcz";
		int result = str1.compareTo(str2);
		System.out.println(result);
		result = str1.compareTo(str3);
		System.out.println(result);
		result = str3.compareTo(str2);
		System.out.println(result);
		result = str1.compareTo(str4);
		System.out.println(result);
		result = str1.compareTo(str5);
		System.out.println(result);*/
		
		String[] dex = new String[5];
		dex[0] = "Mew";
		dex[1] = "Mewtwo";
		dex[2] = "Bulbasaur";
		dex[3] = "Charmander";
		dex[4] = "Pikachu";
		
		int i,j;
		int swapping = 0;
		String mid = "";
		for (i = 0; i < dex.length; i++){
			swapping = i;
			for (j = i+1; j < dex.length; j++){
				if (dex[swapping].compareToIgnoreCase(dex[j]) > 0){
				swapping = j;	
				}
			}
			if (swapping != i){
				mid = dex[i];
				dex[i] = dex[swapping];
				dex[swapping] = mid;
			}
		}
		for (i = 0; i< 5; i++){
			System.out.println(dex[i]);
		}
	}
}
