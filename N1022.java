import java.util.*;
import java.io.*;

public class N1022 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h1 = Integer.parseInt(st.nextToken());
		int w1 = Integer.parseInt(st.nextToken());
		int h2 = Integer.parseInt(st.nextToken());
		int w2 = Integer.parseInt(st.nextToken());
		int map[][] = new int[h2 - h1 + 1][w2 - w1 + 1];
		int size = (h2 - h1 + 1) * (w2 - w1 + 1);
		int cur = 0;
		int y = 0;
		int x = 0;
		int val = 0;
		int dir = 2;
		int len = 0;
		int max = 0;
		int dy[] = { 0, -1, 0, 1 };
		int dx[] = { -1, 0, 1, 0 };
		while (cur != size) {
			if(dir==0||dir==2) len++;
			for (int l = 0; l < len; l++) {
				++val;
				if (h1 <= y && y <= h2 && w1 <= x && x <= w2) {
					map[y - h1][x - w1] = val;
					if(max<val) max = val;
					cur++;
				}
				y+=dy[dir];
				x+=dx[dir];
			}
			dir-=1;
			if(dir<0) dir=3;
		}
		int length=0;
		length = (max+"").length();
		for(int i=0;i<=h2-h1;i++) {
			for(int j=0;j<=w2-w1;j++) {
				System.out.print(String.format("%"+(length)+"d ",map[i][j]));
			}
			System.out.println();
		}
	}
}
/*import java.io.*;
import java.util.*;

public class N1022 {
	
	static int r1;
	static int r2;
	static int c1;
	static int c2;
	static int maxRow;
	static int maxCol;
	static int[][] tornado;
	static String format;
	public static void main(String[] args) throws IOException {
		setting(); draw(); show();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
	}
	
	static void draw() {
		maxRow = Math.max(Math.abs(r1), Math.abs(r2));
		maxCol = Math.max(Math.abs(c1), Math.abs(c2));
		tornado = new int[r2-r1+1][c2-c1+1];
		
		int x = -r1; int y = -c1;
		int num = 1;
		int max = 0;
		
		for(int i=1; i<=(2*maxRow+1)*(2*maxRow+1); i++) {
			if(0<=x && x<r2-r1+1 && 0<=y && y<c2-c1+1) {
				tornado[x][y] = i;
				if(max<i) max = i;
			}
			
			if(i<=num*num) y++;
			else if(i<=num*(num+1)) x--;
			else if(i<=(num+1)*(num+1)) y--;
			else if(i<=(num+1)*(num+2)) x++;
			else { num += 2;
				if(i<=num*num) y++;
				else if(i<=num*(num+1)) x--;
				else if(i<=(num+1)*(num+1)) y--;
				else if(i<=(num+1)*(num+2)) x++;
			}
		}
		int length = (max+"").length();
		format = "%"+length+"d ";
	}
	
	static void show() {
		for (int i=0; i<tornado.length; i++) {
			for (int j=0; j<tornado[i].length; j++) {
				System.out.print(String.format(format, tornado[i][j])+" ");
			} System.out.println();
		}
	}
}*/