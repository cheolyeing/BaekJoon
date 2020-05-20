import java.io.*;
import java.util.*;

public class N1184 {
	static int n, ans=0, map[][];
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+2][n+2];
		StringTokenizer st;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solution() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				ans += LT_RB(i, j) + RT_LB(i, j);
			}
		}
		System.out.println(ans);
	}
	
	static int LT_RB(int x, int y) {
		int[][] arr = new int[n+2][n+2];
		int[] left = new int[(n-x)*(n-y)];
		int[] right = new int[x*y];
		int l=0, r=0, cnt=0;
		
		for(int i=x+1; i<=n; i++) {
			for(int j=y+1; j<=n; j++) {
				arr[i][j] = map[i][j] + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
				left[l++] = arr[i][j];
			}
		}
		
		for(int i=x; i>0; i--) {
			for(int j=y; j>0; j--) {
				if(i==x && j==y) {
					arr[i][j] = map[i][j];
					right[r++] = arr[i][j];
					continue; 
				}
				arr[i][j] = map[i][j] + arr[i+1][j] + arr[i][j+1] - arr[i+1][j+1];
				right[r++] = arr[i][j];
			}
		}
		
		for(int le : left) {
			for(int ri : right) {
				if(le==ri) cnt++;
			}
		}
		
		return cnt;
	}
	
	static int RT_LB(int x, int y) {
		int[][] arr = new int[n+2][n+2];
		int[] left = new int[(n-x)*(y-1)];
		int[] right = new int[x*(n-y+1)];
		int l=0, r=0, cnt=0;
		
		for(int i=x+1; i<=n; i++) {
			for(int j=y-1; j>0; j--) {
				arr[i][j] = map[i][j] + arr[i-1][j] + arr[i][j+1] - arr[i-1][j+1];
				left[l++] = arr[i][j];
			}
		}
		
		for(int i=x; i>0; i--) {
			for(int j=y; j<=n; j++) {
				if(i==x && j==y) {
					arr[i][j] = map[i][j];
					right[r++] = arr[i][j];
					continue;
				}
				arr[i][j] = map[i][j] +arr[i+1][j] + arr[i][j-1] - arr[i+1][j-1];
				right[r++] = arr[i][j];
			}
		}
		
		
		for(int le : left) {
			for(int ri : right) {
				if(le==ri) cnt++;
			}
		}
		
		return cnt;
	}
}
