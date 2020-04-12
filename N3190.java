import java.io.*;
import java.util.*;

public class N3190 {
	
	static int n;
	static int apple;
	static int[][] map;
	static int time = 0;
	static boolean ok = true;
	static int[][] d = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static int going = 0;
	static ArrayList<int[]> snake = new ArrayList<int[]>();
	static int[] pos = new int[2];
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		apple = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for (int i=0; i<apple; i++) {
			String[] pos = br.readLine().split(" ");
			int x = Integer.parseInt(pos[0]);
			int y = Integer.parseInt(pos[1]);
			map[x-1][y-1] = 1;
		}
		
		int action = Integer.parseInt(br.readLine());
		int[] start = {0, 0};
		snake.add(start);
		map[0][0] = -1;
		
		
		for (int i=0; i<action; i++) {
			String[] act = br.readLine().split(" ");
			int numOfAct = Integer.parseInt(act[0]);
			String direct = act[1];
			int beforeAct = time;
			
			for (int j=0; j<numOfAct-beforeAct; j++) {
				pos = getHead();
				turn(pos[0], pos[1]);
				/*System.out.println();
				System.out.println("<"+time+">");
				showMap();*/
				
			}
			
			if(direct.equals("D")) { going = (going+1) % 4; } 
			else { going = (going+3) % 4; }
		}
		
		while (true) {
			pos = getHead();
			turn(pos[0], pos[1]);
			/*System.out.println();
			System.out.println("<"+time+">");
			showMap();*/
		}
	}
	
	static void turn (int x, int y) {
		time++;
		int nx = x + d[going][0];
		int ny = y + d[going][1];
		if(finish(nx, ny)) { System.out.println(time); System.exit(0); }
		
		int[] put = {nx, ny};
		snake.add(put);
		
		if(map[nx][ny] != 1) { 
			int[] tail = snake.get(0);
			map[tail[0]][tail[1]] = 0;
			snake.remove(tail);
		} 
		map[nx][ny] = -1;
		int[] tmp = {nx, ny};
		pos = tmp;
	}
	
	static boolean finish (int x, int y) {
		if(x<0 || y<0 || x>=n || y>=n) { return true; }
		if(map[x][y]==-1) {
			return true;
		} else { return false; }
	}
	
	static int[] getHead() {
		return snake.get(snake.size()-1);
	}
	
	static void showMap() {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(String.format("%3d", map[i][j]));
			} System.out.println();
		}
	}
}