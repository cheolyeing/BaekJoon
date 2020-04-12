import java.io.*;
import java.util.*;

public class N3709 {
	static int tc, n, r, map[][];
	static int[][] d = {{0,0}, {1,0}, {0,-1}, {-1,0}, {0,1}};
	
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int i=0; i<tc; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			map = new int[n+1][n+1];
			
			for (int j=0; j<r; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 5;
			}
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			int direct = -1;
			if(startX==0) direct = 1;
			else if(startX==n+1) direct = 3;
			else if(startY==0) direct = 4;
			else if(startY==n+1) direct = 2;
			
			while(true) {
				startX += d[direct][0];
				startY += d[direct][1];
				
				if(!inRange(startX, startY)) {
					System.out.println(startX+" "+startY); break;
				}
				
				if(map[startX][startY]!=0) {
					direct++;
					if(direct==5) direct=1;
					if(map[startX][startY]==direct) {
						System.out.println("0 0"); break;
					}
					map[startX][startY] = direct;
				}
			}
		}
	}
	
	static boolean inRange(int x, int y) {
		if(x>0 && x<=n && y>0 && y<=n) return true;
		else return false;
	}
}