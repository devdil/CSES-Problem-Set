import java.util.*;

class PermutationsSolution{

	public static void printIfPermutationPossible(int n){
		if (n==2 || n==3)
			System.out.println("NO SOLUTION");
		else{

			// print odd first
			String[] str = new String[n];

			int index=0;
			for(int i=2;i<=n;i+=2)
				str[index++] = String.valueOf(i);
			for(int i=1;i<=n;i+=2)
				str[index++] = String.valueOf(i);
			
			System.out.print(String.join(" ", str));

		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printIfPermutationPossible(n);
	}
}

