import java.io.*;
import java.util.*;

public class N17406_RE {
	static int n, m, k, ans=Integer.MAX_VALUE;
	static int[][] arr;
	static int[][] spin;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		setting();
		backTracking(new int[k], 0);
		System.out.println(ans);
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n+1][m+1];
		spin = new int[k+1][3];
		visited = new boolean[k+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1; i<k+1; i++) {
			st = new StringTokenizer(br.readLine());
			spin[i][0] = Integer.parseInt(st.nextToken());
			spin[i][1] = Integer.parseInt(st.nextToken());
			spin[i][2] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution(int[] num) {
		int[][] narr = makeArr();
		for(int i=0; i<k; i++) {
			spinOper(narr, spin[num[i]][0], spin[num[i]][1], spin[num[i]][2]);
			//showArr(narr);
		}
		ans = Math.min(ans, arrValue(narr));
	}
	
	static void backTracking(int[] num, int idx) {
		if(idx==k) {
			solution(num);
			return;
		}
		for(int i=1; i<=k; i++) {
			if(!visited[i]) {
				visited[i] = true;
				num[idx] = i;
				backTracking(num, idx+1);
				visited[i] = false;
			}
		}
	}
	
	static int[][] makeArr() {
		int[][] narr = new int[n+1][m+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				narr[i][j] = arr[i][j];
			}
		}
		return narr;
	}
	
	static void spinOper(int[][] narr, int r, int c, int s) {
		if(s==0) return;
		int x = r-s; int y = c-s;
		int tmp = narr[x][y];
		while(true) {
			narr[x++][y] = narr[x][y];
			if(x==r+s) break;
		}
		while(true) {
			narr[x][y++] = narr[x][y];
			if(y==c+s) break;
		}
		while(true) {
			narr[x--][y] = narr[x][y];
			if(x==r-s) break;
		}
		while(true) {
			narr[x][y--] = narr[x][y];
			if(y==c-s) break; 
		}
		narr[x][y+1] = tmp;
		spinOper(narr, r, c, s-1);
	}
	
	static int arrValue(int[][] arr) {
		int minVal = Integer.MAX_VALUE;
		for(int i=1; i<=n; i++) {
			int val=0;
			for(int j=1; j<=m; j++) {
				val += arr[i][j];
			}
			minVal = minVal>val ? val : minVal;
		}
		return minVal;
	}
	
	static void showArr(int[][] arr) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				System.out.print(arr[i][j]+" ");
			} System.out.println();
		} System.out.println("---------------------");
	}
}
