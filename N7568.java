import java.util.*;

public class N7568 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] info = new int[n][3];
		
		for (int i=0; i<n; i++) {
			info[i][0] = sc.nextInt();
			info[i][1] = sc.nextInt();
			info[i][2] = 1;
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if(info[i][0]>info[j][0] && info[i][1]>info[j][1])
					info[j][2]++;
			}
		}
		
		for (int i=0; i<n; i++) {
			System.out.print(info[i][2]+" ");
		}
	}
}