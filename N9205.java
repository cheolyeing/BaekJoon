import java.io.*;
import java.util.*;
import java.awt.*;

public class N9205 {
	static int n, beer;
	static Point home, fest;
	static ArrayList<Point> cvs;
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; t++) {
			beer = 20;
			n = Integer.parseInt(br.readLine());
			cvs = new ArrayList<Point>();
			st = new StringTokenizer(br.readLine());
			home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				cvs.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			st = new StringTokenizer(br.readLine());
			fest = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			System.out.println(bfs());
		}
	}
	
	static void solution() {
		
	}
	
	static String bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(home);
		
		while(!q.isEmpty()) {
			int s = q.size();
			for(int i=0; i<s; i++) {
				Point p = q.poll();
				if(uclidDist(p, fest)<=1000) return "happy";
				for(int k=0; k<cvs.size(); k++) {
					Point t = cvs.get(k);
					if(uclidDist(p, t)<=1000) {
						cvs.remove(k);
						q.add(t);
					}
				}
			}
		}
		return "sad";
	}
	
	static int uclidDist(Point a, Point b) {
		return Math.abs(a.x-b.x) + Math.abs(a.y-b.y);
	}
}
