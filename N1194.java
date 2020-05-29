import java.io.*;
import java.util.*;

public class N1194 {
	static int n, m;
	static Node start;
	static boolean end=false;
	static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][][] visited;
	static char[][] map;
	static class Node {
		public int x, y;
		public int bit;
		public Node(int x, int y, int bit) {
			this.x = x; this.y = y; this.bit = bit;
		}
	}
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m][1<<8];
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='0') {
					start = new Node(i, j, 1<<7);
					map[i][j] = '.';
				}
			}
		}
	}
	
	static void solution() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(start);
		visited[start.x][start.y][start.bit] = true; 
		
		int time = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			if(end) break;
			for(int i=0; i<size; i++) {
				Node p = q.poll();
				for(int k=0; k<4; k++) {
					Node np = new Node(p.x+d[k][0], p.y+d[k][1], p.bit);
					if(next(np)) q.add(np);
				}
			}
			time++;
		}
		System.out.println(end ? time : -1);
	}
	
	static boolean inRange(Node p) {
		return p.x>=0 && p.x<n && p.y>=0 && p.y<m;
	}
	
	static boolean next(Node p) {
		if(!inRange(p)) return false;
		if(visited[p.x][p.y][p.bit]) return false;
		visited[p.x][p.y][p.bit] = true;
		char c = map[p.x][p.y];
		if(c=='a' || c=='b' || c=='c' || c=='d' || c=='e' || c== 'f') {
			int num = (int)(c-'a');
			p.bit = p.bit | 1<<num;
			return true;
		}
		if(c=='#') return false;
		if(c=='A' || c=='B' || c=='C' || c=='D' || c=='E' || c=='F') {
			int num = (int)(c-'A');
			if((p.bit & 1<<num) == 1<<num) {
				return true;
			} else return false;
		}
		if(c=='1') {
			end = true; return true;
		}
		return true;
	}
}
