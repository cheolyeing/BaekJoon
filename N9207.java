import java.io.*;
import java.util.*;

public class N9207 {
	static int ans = 0, minMove = 0, cnt = 0;
	static char[][] map = new char[5][9];
	static int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=0; i<tc; i++) {
			cnt = 0;
			for(int j=0; j<5; j++) {
				String input = br.readLine();
				for(int k=0; k<9; k++) {
					map[j][k] = input.charAt(k);
					if(map[j][k]=='o') cnt++;
				}
			}
			ans = 0; minMove = 0;
			solution(map, 0, 0);
			System.out.println(cnt-ans+" "+minMove);
			if(i!=tc-1) br.readLine();
		}
	}
	
	static void solution(char[][] tmp, int move, int removed) {
		//showArr(tmp);
		for(int i=0; i<5; i++) {
			for(int j=0; j<9; j++) {
				if(tmp[i][j]=='o') {
					for(int k=0; k<4; k++) {
						int nx = i + d[k][0];
						int ny = j + d[k][1];
						if(inRange(nx, ny) && tmp[nx][ny]=='o') {
							int nnx = i + 2*d[k][0];
							int nny = j + 2*d[k][1];
							if(inRange(nnx, nny) && tmp[nnx][nny]=='.') {
								tmp[i][j]='.';
								tmp[nx][ny]='.';
								tmp[nnx][nny]='o';
								solution(tmp, move+1, removed+1);
								tmp[i][j]='o';
								tmp[nx][ny]='o';
								tmp[nnx][nny]='.';
							}
						}
					}
				}
			}
		}
		if(ans<removed) {
			ans = removed; minMove = move;
		} else if(ans==removed) minMove = Math.min(minMove, move);
	}
	
	static boolean inRange(int x, int y) {
		return (x>=0 && x<5 && y>=0 && y<9);
	}
	
	static void copyArr(char[][] arr1, char[][] arr2) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<9; j++) {
				arr2[i][j] = arr1[i][j];
			}
		}
	}
	
	static void showArr(char[][] arr) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(arr[i][j]);
			} System.out.println();
		} System.out.println("------------------");
	}
}
