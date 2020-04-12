import java.io.*;
import java.util.*;

public class N15685 {
	
	static boolean[][] map = new boolean[101][101];
	static int n;
	static int[] x;
	static int[] y;
	static int[] d;
	static int[] g;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		setting();
		draw();
		//showMap();
		count();
		System.out.println(answer);
	}
	
	static void count() {
		for (int i=0; i<100; i++) {
			for (int j=0; j<100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
					answer++;
				}
			}
		}
	}
	
	static void draw() {
		for (int i=0; i<n; i++) {
			ArrayList<int[]> dc = dragonCurve(x[i], y[i], d[i], g[i]);
			for (int j=0; j<dc.size(); j++) {
				//System.out.println((dc.get(j)[0])+", "+(dc.get(j)[1]));
				map[dc.get(j)[0]][dc.get(j)[1]] = true;
			} //showMap();
		}
	}
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		x = new int[n]; y = new int[n]; d = new int[n]; g = new int[n];
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
			g[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static ArrayList<int[]> dragonCurve(int x, int y, int d, int g) {
		ArrayList<int[]> dc = new ArrayList<int[]>();
		int[] first = {x, y};
		dc.add(first);
		int[] second;
		if(d==0) {
			int[] tmp = {x+1, y}; second = tmp;
		} else if(d==1) {
			int[] tmp = {x, y-1}; second = tmp;
		} else if(d==2) {
			int[] tmp = {x-1, y}; second = tmp;
		} else {
			int[] tmp = {x, y+1}; second = tmp;
		} dc.add(second);
		
		
		
		for (int i=1; i<=g; i++) {
			int critX = dc.get(dc.size()-1)[0];
			int critY = dc.get(dc.size()-1)[1];
			int length = dc.size();
			for (int j=0; j<length; j++) {
				int dx = dc.get(length-j-1)[0]-critX;
				int dy = dc.get(length-j-1)[1]-critY;
				
				int newX = critX-dy;
				int newY = critY+dx;
				int[] tmp = {newX, newY};
				dc.add(tmp);
			}
		}
		return dc;
	}
	
	static void showMap() {
		for(int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				if(map[j][i]) {
					System.out.print("O ");
				} else {System.out.print("X "); }
			} System.out.println();
		} System.out.println("_________________________");
	}
}