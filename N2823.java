import java.io.*;
import java.util.*;

public class N2823 {
	static int r, c;
	static int[][] map;
	static int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r+2][c+2];
		
		for(int i=1; i<=r; i++) {
			String s = br.readLine();
			for(int j=1; j<=c; j++) {
				if(s.charAt(j-1)=='.') {
					map[i][j]=1;
				} else map[i][j]=2;
			}
		}
		
		for(int i=1; i<=r; i++) {
			for(int j=1; j<=c; j++) {
				if(map[i][j]==2) continue;
				int canGo=0;
				for(int k=0; k<4; k++) {
					int x = i + d[k][0];
					int y = j + d[k][1];
					if(map[x][y]==1) canGo++;
				}
				if(canGo<2) {
					System.out.println(1);
					System.exit(0);
				}
			}
		}
		System.out.println(0);
	}
}