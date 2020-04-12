import java.io.*;
import java.util.*;

public class N15684 {
	static int n, m, h, ans=0;
	static int[][] ladder;
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		ladder = new int[h+1][n+2];
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ladder[a][b] = 1; ladder[a][b+1] = -1;
		} //showLadder();
		
		for (int i=0; i<=3; i++) {
			dfs(i, 0, 1, 1);
		} System.out.println(-1);
	}
	
	static void dfs(int size, int cnt, int x, int y) {
		if(cnt==size) {
			if(check()) {
			//showLadder();
			System.out.println(size);
			System.exit(0);
			} return;
		}
		
		else if(x>h) return;
		else if(y>=n) dfs(size, cnt, x+1, 1);
		else if(ladder[x][y]!=0) dfs(size, cnt, x, y+1);
		else {
			for(int i=x; i<=h; i++) {
				for(int j=1; j<n; j++) {
					if(ladder[i][j]==0 && ladder[i][j+1]==0) {
						ladder[i][j] = 1; ladder[i][j+1] = -1;
						dfs(size, cnt+1, x, y+2);
						ladder[i][j] = 0; ladder[i][j+1] = 0;
					}
				}
			}
		}
	}
	
	static boolean check () {
		for (int i=1; i<=n; i++) {
			int res = i, idx = 1;
			while(idx<=h) {
				res = res + ladder[idx][res];
				idx++;
				if(idx==h+1 && res!=i) return false;
			}
		}
		return true;
	}
	
	static void showLadder() {
		for (int i=1; i<=h; i++) {
			for (int j=1; j<=n; j++) {
				char c = '0';
				if(ladder[i][j]==0) c = '¦¢';
				else if(ladder[i][j]==1) c = '¦§';
				else c = '¦©';
				System.out.print(c);
			}
			System.out.println();
		}
		System.out.println("_________________\n");
	}
}