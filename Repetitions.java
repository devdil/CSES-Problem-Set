import java.util.*;

class Repetitions{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(calculateRepitions(s));
	}
	public static int calculateRepitions(String input){
		if (input == null)
			return 0;
		else{
			int maxRepeatingLength = 1;
			char lastRepeatingCharacter=input.charAt(0);
			int left=0;
			for(int right=1;right<input.length();){
				if (input.charAt(right)!=lastRepeatingCharacter){
					left=right;
					lastRepeatingCharacter = input.charAt(right);
				}
				maxRepeatingLength = Math.max(maxRepeatingLength, (right-left)+1);
				right +=1;
			}

			return maxRepeatingLength;
		}
	}

}