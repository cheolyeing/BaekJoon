import java.util.*;

public class N2309 {
	static int sum = -100;
	static int[] nan = new int[9];
	static ArrayList<Integer> ans = new ArrayList();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i=0; i<9; i++) {
			nan[i] = sc.nextInt();
			sum += nan[i];
		}
		
		for (int i=0; i<9; i++) {
			find(i);
		}
	}
	
	static void find(int idx) {
		for (int i=idx+1; i<9; i++) {
			if(nan[i]+nan[idx]==sum) {
				for (int j=0; j<9; j++) {
					if(j==i || j==idx) continue;
					ans.add(nan[j]);
				}
				Collections.sort(ans);
				for (int k=0; k<7; k++) {
					System.out.println(ans.get(k));
				}
				System.exit(0);
			}
		}
	}
}