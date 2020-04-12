import java.io.*;
import java.util.*;

public class N1986 {
	static int n, m;
	static int[][] chess;
	static boolean[][] visited;
	static int[][] line = {{1,0},{-1,0},{0,1},{0,-1}};
	static int[][] diagonal = {{1,1},{1,-1},{-1,1},{-1,-1}};
	static int[][] knight = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
	public static void main(String[] args) throws IOException {
		setting();
		System.out.println(solution());
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		chess = new int[n+1][m+1];
		visited = new boolean[n+1][m+1];
		
		st = new StringTokenizer(br.readLine());
		int Q = Integer.parseInt(st.nextToken());
		for(int i=0; i<Q; i++) {
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			chess[x][y] = 1; // Queen
		}
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		for(int i=0; i<K; i++) {
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			chess[x][y] = 2; // Knight
		}
		
		st = new StringTokenizer(br.readLine());
		int P = Integer.parseInt(st.nextToken());
		for(int i=0; i<P; i++) {
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			chess[x][y] = 3; // Pawn
			visited[x][y] = true;
		}
	}
	
	static int solution() {
		int answer = 0;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(chess[i][j]==1) queenMove(i, j);
				else if(chess[i][j]==2) knightMove(i, j);
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(!visited[i][j]) answer++;
			}
		}
		return answer;
	}
	
	static void queenMove(int x, int y) {
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x + diagonal[i][0], ny = y + diagonal[i][1];
			while(inRange(nx, ny) && chess[nx][ny]==0) {
				visited[nx][ny] = true;
				nx += diagonal[i][0];
				ny += diagonal[i][1];
			}
			
			nx = x + line[i][0]; ny = y + line[i][1];
			while(inRange(nx, ny) && chess[nx][ny]==0) {
				visited[nx][ny] = true;
				nx += line[i][0];
				ny += line[i][1];
			}
		}
	}
	
	static void knightMove(int x, int y) {
		visited[x][y] = true;
		for(int i=0; i<8; i++) {
			int nx = x + knight[i][0];
			int ny = y + knight[i][1];
			if(inRange(nx, ny) && chess[nx][ny]==0) {
				visited[nx][ny] = true;
			}
		}
	}
	
	static boolean inRange(int x, int y) {
		return (x>=1 && x<=n && y>=1 && y<=m);
	}
	
	static void showArray(int[][] arr) {
		for(int i=1; i<arr.length; i++) {
			for(int j=1; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			} System.out.println();
		} System.out.println("--------------");
	}
}