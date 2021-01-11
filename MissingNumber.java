import java.util.*;

class MissingNumber{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		long totalNumbers = sc.nextInt();
		long expectedSum=((totalNumbers)*(totalNumbers+1))/2;
		long currentSum = 0;
		while(totalNumbers -- > 1){
			currentSum += sc.nextLong();
		}

		System.out.println(expectedSum-currentSum);
		
	}


}