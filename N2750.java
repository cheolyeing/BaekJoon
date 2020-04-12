import java.util.*;
public class N2750 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int n = sc.nextInt();

		for(int i=0; i<n; i++) {list.add(sc.nextInt());}
		Collections.sort(list);		
		for(int i : list) {System.out.println(i);}
	}
}