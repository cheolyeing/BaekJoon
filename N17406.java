import java.io.*;
import java.util.*;

public class N17406 {
	static int n, m, k, ans = Integer.MAX_VALUE;
	static int[][] arr;
	static int[][] cal;
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
		arr = new int[n][m];
		cal = new int[k][3];
		visited = new boolean[k];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			cal[i][0] = Integer.parseInt(st.nextToken());
			cal[i][1] = Integer.parseInt(st.nextToken());
			cal[i][2] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void backTracking(int[] sub, int num) {
		if(num==k) {
			solution(cal, arr, sub);
			return;
		}
		
		for(int i=0; i<k; i++) {
			if(!visited[i]) { 
				visited[i] = true;
				sub[num] = i;
				backTracking(sub, num+1);
				visited[i] = false;
			}
		}
	}
	
	static void solution(int[][] cal, int[][] arr, int[] sub) {
		
		for(int i=0; i<k; i++) {
			int[][] tmp = oper(arr, cal[sub[i]][0]-1, cal[sub[i]][1]-1, cal[sub[i]][2]);
			arr = tmp;
		}
		ans = Math.min(arrVal(arr), ans);
	}
	
	static int arrVal(int[][] arr) {
		int res = Integer.MAX_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			int sum = 0;
			for(int j=0; j<arr[i].length; j++) {
				sum += arr[i][j];
			}
			res = Math.min(res, sum);
		}
		return res;
	}
	
	static int[][] oper(int[][] arr, int r, int c, int s) {
		int[][] res = new int[arr.length][arr[0].length];
		
		for(int i=s; i>0; i--)
			spin(arr, res, r, c, i);
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(res[i][j]==0) res[i][j] = arr[i][j];
			}
		}
		
		return res;		
	}
	
	static void spin(int[][] arr, int[][] res, int r, int c, int s) {
		int x1 = r-s, x2 = r+s;
		int y1 = c-s, y2 = c+s;
		
		for(int i=y1+1; i<=y2; i++)
			res[x1][i] = arr[x1][i-1];
		
		for(int i=x1+1; i<=x2; i++)
			res[i][y2] = arr[i-1][y2];
		
		for(int i=y2-1; i>=y1; i--)
			res[x2][i] = arr[x2][i+1];
		
		for(int i=x2-1; i>=x1; i--)
			res[i][y1] = arr[i+1][y1];
	}
	
	static void showArr(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			} System.out.println("");
		} System.out.println("--------------------");
	}
}