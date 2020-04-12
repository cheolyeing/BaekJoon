import java.io.*;
import java.util.*;

public class N18808 {
	static int n, m, k;
	static boolean possible = false;
	static int[][] notebook;
	static ArrayList<int[][]> sticker = new ArrayList<int[][]>();
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		notebook = new int[n][m];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[][] tmp = new int[a][b];
			for(int x=0; x<a; x++) {
				st = new StringTokenizer(br.readLine());
				for(int y=0; y<b; y++) {
					tmp[x][y] = Integer.parseInt(st.nextToken());
				}
			}
			sticker.add(tmp);
		}
	}
	
	static void solution() {
		for(int i=0; i<k; i++) {
			int[][] arr = sticker.get(i);
			loop :
			for(int s=0; s<4; s++) {
				for(int x=0; x<n; x++) {
					for(int y=0; y<m; y++) {
						possible = false;
						attach(arr, x, y);
						if(possible) break loop;
					}
				}
				int[][] tmp = spin(arr);
				arr = tmp;
			}
		}
		int ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				ans += notebook[i][j];
			}
		}
		System.out.println(ans);
	}
	
	static void attach(int[][] arr, int x, int y) {
		if(n-x<arr.length || m-y<arr[0].length) {
			return;
		} else {
			if(compare(arr, x, y)) stick(arr, x, y);
		}
	}
	
	static void stick(int[][] arr, int x, int y) {
		possible = true;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j]==1) notebook[x+i][y+j]=1;
			}
		}
	}
	
	static boolean compare(int[][] arr, int x, int y) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j]==1 && notebook[x+i][y+j]==1) return false;
			}
		}
		return true;
	}
	
	static int[][] spin(int[][] arr) {
		int[][] res = new int[arr[0].length][arr.length];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				res[j][arr.length-1-i] = arr[i][j];
			}
		}
		return res;
	}
	
	static void showArr(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			} System.out.println();
		} System.out.println("-------------");
	}
}