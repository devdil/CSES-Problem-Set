import java.util.*;

public class WeirdAlgorithm{

	public static void simulateWeird(long n){

		while (n!=1){
			System.out.print(n+" ");
			if (n%2==0)
				n = n/2;
			else
				n = (n*3)+1;
		}
		System.out.print("1");
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		simulateWeird(sc.nextLong());
	}
}
