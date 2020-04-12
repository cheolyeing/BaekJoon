import java.io.*;
import java.util.*;
import java.awt.*;
public class N11559 {
	
	static char[][] puyo = new char[12][6];
	static boolean[][] visited = new boolean[12][6];
	static int pang = 0;
	static ArrayList<Point> list;
	
	public static void main(String[] args) throws IOException {
		setting();
		action();
		System.out.println(pang);
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i=0; i<12; i++) {
			puyo[i] = br.readLine().toCharArray();
		}
	}
	
	static void fall() {
		for (int j=0; j<6; j++) {
			int idx = 11;
			for (int i=0; i<12; i++) {
				if(puyo[11-i][j]!='.') {
					puyo[idx][j] = puyo[11-i][j];
					if(idx!=11-i) puyo[11-i][j] = '.';
					idx--;
				}
			}
		}
	}
	
	static void action() {
		visited = new boolean[12][6];
		boolean deleted = false;
		for (int i=0; i<12; i++) {
			for (int j=0; j<6; j++) {
				if(puyo[i][j]!='.' && !visited[i][j]) {
					list = new ArrayList<Point>();
					bfs(i, j, puyo[i][j]);
					if(list.size()>=4) {
						deleted = true;
						for (Point p : list) {
							puyo[p.x][p.y] = '.'; 
						}
					}
				}
			}
		}
		if(deleted) {
			fall(); pang++; action();
		}
	}
	
	static void bfs(int x, int y, char c) {
		Queue<Point> q = new LinkedList();
		Point start = new Point(x, y);
		q.add(start); list.add(start);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i=0; i<size; i++) {
				Point p = q.poll();
				visited[p.x][p.y] = true; 
				
				for (int j=0; j<4; j++) {
					Point np = d(p, j);
					if(inRange(np) && puyo[np.x][np.y]==c && !visited[np.x][np.y]) {
						q.add(np); list.add(np);
					}
				}
			}
		}
	}
	
	static Point d(Point p, int i) {
		if(i==0) return new Point(p.x+1, p.y);
		else if(i==1) return new Point(p.x-1, p.y);
		else if(i==2) return new Point(p.x, p.y+1);
		else return new Point(p.x, p.y-1);
	}
	
	static boolean inRange(Point p) {
		if(0<=p.x && p.x<12 && 0<=p.y && p.y<6) return true;
		else return false;
	}
	
	static void show() {
		for (int i=0; i<12; i++) {
			for (int j=0; j<6; j++) {
				System.out.print(puyo[i][j]+" ");
			}System.out.println();
		}System.out.println("----------------\n");
	}
}