import java.util.*;

public class VirtualFriends{

	private static HashMap<String, Integer> personToInt;

	private static int[] size;
	private static int[] id;

	private static int idx = 0;

	public static int findRoot(int person){

		int personRoot = person;

		while(personRoot!=id[personRoot]){
			personRoot = id[personRoot];
		}

		while (person!=personRoot){
			int next = id[person];
			id[person] = personRoot;
			person=next;
		}

		return personRoot;

	}


	public static void unify(String friend1, String friend2){

		if (!personToInt.containsKey(friend1)){
			personToInt.put(friend1, idx++);
		}

		if (!personToInt.containsKey(friend2)){
			personToInt.put(friend2, idx++);
		}

		unify(personToInt.get(friend1), personToInt.get(friend2));
	}

	public static boolean connected(int p, int q) {
    	return findRoot(p) == findRoot(q);
  	}

  	 public static int componentSize(int p) {
   	 	return size[findRoot(p)];
 	 }


	public static void unify(int x, int y){


		for(int j=0;j<id.length;j++)
			System.out.print(id[j]+",");

		System.out.println();

		for(int j=0;j<id.length;j++)
			System.out.print(size[j]+",");

		System.out.println();

		//System.out.println(x+","+y);
		if (connected(x, y)){
			System.out.println(componentSize(x));
			return;
		}


		int xRt = findRoot(x);
		int yRt = findRoot(y);

		if (size[xRt] > size[yRt]){
			size[xRt] += size[yRt];
			id[yRt] = xRt;
			System.out.println(componentSize(y));
		}else{
			size[yRt] += size[xRt];
			id[xRt] = yRt;
			System.out.println(componentSize(x));
		}


	}

	public static void processFriendShips(int friendShips, Scanner sc){

		size = new int[friendShips+1];
		id = new int[friendShips+1];



		for(int i=0;i<friendShips+1;i++){
			size[i] =1;
			id[i] = i;
		}

		for (int i=0;i<friendShips;i++){
			String friend1 = sc.next();
			String friend2 = sc.next();

			unify(friend1, friend2);
		}

	}

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while (testCases -- > 0){
			int friendShips =sc.nextInt();
			sc.nextLine();
			personToInt = new HashMap<>();
			idx = 0;
			processFriendShips(friendShips, sc);
		}

	}

}