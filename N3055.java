import java.io.*;
import java.util.*;

public class N3055 {
	
	static int r;
	static int c;
	static char[][] map; // D = 9, S = 1, . = 2, * = 3
	static ArrayList<int[]> water = new ArrayList<int[]> ();
	static boolean visited[][];
	static int[][] d = { {1,0}, {-1,0}, {0,1}, {0,-1} };
	static Queue que = new LinkedList<int[]>();
	
	public static void main (String[] args) throws IOException {
		setting();
		BFS(0);
		showMap();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r+2][c+2];
		visited = new boolean[r+2][c+2];
		
		for (int i=0; i<r; i++) {
			String input = br.readLine();
			for (int j=0; j<c; j++) {
				map[i+1][j+1] = input.charAt(j);
				if(input.charAt(j)=='*') {
					int[] tmp = {i+1, j+1};
					water.add(tmp);
					visited[i+1][j+1] = true;
				} else if (input.charAt(j)=='X') {
					visited[i+1][j+1] = true;
				} else if (input.charAt(j)=='S') {
					int[] tmp = {i+1, j+1};
					que.add(tmp);
				}
			}
		}
	}
	
	static void water() {
		int length = water.size();
		for (int i=0; i<length; i++) {
			int[] pos = water.get(i);
			//water.remove(pos);
			for (int j=0; j<4; j++) {
				int nx = pos[0] + d[j][0];
				int ny = pos[1] + d[j][1];
				if(map[nx][ny]=='.' || map[nx][ny]=='S') {
					int[] tmp = {nx, ny};
					water.add(tmp);
					visited[nx][ny] = true;
					map[nx][ny] = '*';
				}
			}
		}
	}
	
	static void BFS(int time) {
		
		
		while(!que.isEmpty()) {
			int length = que.size();
			for (int i=0; i<length; i++) {
				int[] pos = (int[]) que.poll();
				//System.out.println(pos[0]+", "+pos[1]);
				if(map[pos[0]][pos[1]]=='D') {
					System.out.println(time); System.exit(0);
				} else if(map[pos[0]][pos[1]]=='*') {
					continue;
				} else {
					for (int j=0; j<4; j++) {
						int nx = pos[0]+d[j][0];
						int ny = pos[1]+d[j][1];
						if(!visited[nx][ny] && (map[nx][ny] == '.' || map[nx][ny]=='D') ) {
							int[] tmp = {nx, ny};
							visited[nx][ny] = true;
							que.add(tmp);
						}
					}
				}
			} water(); BFS(time+1);
		} System.out.println("KAKTUS"); System.exit(0);
	}
	
	static void showMap() {
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			} System.out.println();
		} System.out.println("_____________");
	}
}