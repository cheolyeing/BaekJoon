import java.io.*;
import java.util.*;

public class N2239 {
	static int[][] sdoku = new int[9][9];
	static boolean[][][] visited = new boolean[3][9][10];
	// 0 가로, 1 세로, 2묶음
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			String s = br.readLine();
			for(int j=0; j<9; j++) {
				sdoku[i][j] = s.charAt(j)-'0';
				visited[0][i][sdoku[i][j]] = true;
				visited[1][j][sdoku[i][j]] = true;
				visited[2][area(i,j)][sdoku[i][j]] = true;
			}
		}
		backTracking(sdoku);
	}
	
	static void backTracking(int[][] arr) {
		showArr(arr);
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(arr[i][j]==0) {
					int x = i/3, y = j/3;
					boolean[] visited = new boolean[10];
					for(int k=0; k<9; k++) {
						visited[arr[i][k]] = true;
						visited[arr[k][j]] = true;
					}
					for(int a=x*3; a<x*3+3; a++) {
						for(int b=y*3; b<y*3+3; b++) {
							visited[arr[a][b]] = true;
						}
					}
					for(int k=1; k<=9; k++) {
						if(!visited[k]) {
							arr[i][j] = k;
							backTracking(arr);
						}
					}
					return;
				}
			}
		}
		showArr(arr);
	}
	
	static void showArr(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]);
			} System.out.println();
		}System.out.println("---------------------------");
	}
	
	static int area(int x, int y) {
		int areaX = x/3;
		int areaY = y/3;
		return areaX*3 + areaY;
	}
}