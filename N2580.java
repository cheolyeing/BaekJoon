import java.io.*;
import java.util.*;

public class N2580 {
	static int min = 14;
	static void BackTracking(int empty, int[][] sdoku) {
		
		if(empty==0) { 
			for (int i=1; i<=9; i++) {
				for (int j=1; j<=9; j++) {
					System.out.print(sdoku[i][j]+" ");
				} System.out.println();
			} System.exit(0);
			return; }
		
		for (int i=1; i<=9; i++) {
			for (int j=1; j<=9; j++) {
				if(sdoku[i][j]==0) {
					ArrayList<Integer> ansList = Available_Input(i, j, sdoku);
					if(ansList.size()==1) {
						sdoku[i][j] = ansList.get(0);
						BackTracking(empty-1, sdoku);
					} else {
						for (int k=0; k<ansList.size(); k++) {
							sdoku[i][j]=ansList.get(k);
							BackTracking(empty-1, sdoku);
							sdoku[i][j]=0;
						}
					} return;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
			
		int empty = 0;
		int[][] sdoku = new int[10][10];
		for(int i=1; i<=9; i++) {
			for (int j=1; j<=9; j++) {
				int tmp = sc.nextInt();
				sdoku[i][j] = tmp;
				if(tmp==0) { empty++; }
			}
		}
		BackTracking(empty, sdoku);
	}
	
	public static ArrayList<Integer> Available_Input(int x, int y, int[][] sdoku) {
		int m, n;
		if(x<=3) { m = 1; }
		else if(x<=6) { m = 2; }
		else { m = 3; }
		if(y<=3) { n = 1; }
		else if(y<=6) { n = 2; }
		else { n = 3; }
		
		boolean[] available = new boolean[10]; 
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		for (int i=1; i<=9; i++) { 
			available[sdoku[x][i]] = true;
			available[sdoku[i][y]] = true;
		}
		
		for (int i=3*m-2; i<=3*m; i++) {
			for (int j=3*n-2; j<=3*n; j++) {
				available[sdoku[i][j]] = true;
			}
		}
		
		for (int i=1; i<=9; i++) {
			if(!available[i]) {
				ans.add(i);
			}
		}
		return ans;
	}
}