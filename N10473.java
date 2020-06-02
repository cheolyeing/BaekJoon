import java.io.*;
import java.util.*;

public class N10473 {
	static int n;
	static final double INF = 10000000000.0;
	static double d[];
	static Point[] pos;
	
	static class Point {
		public double x, y;
		public Point(double x, double y) {
			this.x = x; this.y = y;
		}
	}
	
	static class Pair implements Comparable<Pair> {
		public int node;
		public double cost;
		public Pair(int node, double cost) {
			this.node = node; this.cost = cost;
		}
		@Override
		public int compareTo(Pair pair) {
			// TODO Auto-generated method stub
			return this.cost > pair.cost ? 1 : -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		double sx = Double.parseDouble(st.nextToken());
		double sy = Double.parseDouble(st.nextToken());
		st = new StringTokenizer(br.readLine());
		double fx = Double.parseDouble(st.nextToken());
		double fy = Double.parseDouble(st.nextToken());
		
		n = Integer.parseInt(br.readLine());
		d = new double[n+2];
		Arrays.fill(d, INF);
		d[0] = 0;
		pos = new Point[n+2];
		pos[0] = new Point(sx, sy);
		pos[n+1] = new Point(fx, fy);
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			pos[i] = new Point(x, y);
		}
	}
	
	static void solution() {
		Dijkstra();
		System.out.println(d[n+1]);
		
		/* 플로이드 와샬
		 * for(int k=0; k<n+2; k++) {
			for(int i=0; i<n+2; i++) {
				for(int j=0; j<n+2; j++) {
					if(time[i][j]>time[i][k]+time[k][j]) time[i][j] = time[i][k] + time[k][j];
				}
			}
		}
		System.out.println(time[0][n+1]);*/
	}
	
	static void Dijkstra() {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		pq.add(new Pair(0, 0));
		
		while(!pq.isEmpty()) {
			Pair from = pq.poll();
			if(from.cost > d[from.node]) continue;
			for(int i=0; i<n+2; i++) {
				if(from.node==i) continue;
				double tD = d[from.node] + time(pos[from.node], pos[i], !(from.node==0 || from.node==n+1));
				if(d[i] > tD) {
					d[i] = tD;
					pq.add(new Pair(i, d[i]));
				}
			}
		}
	}
	
	static double time(Point p1, Point p2, boolean cannon) {
		double walk = (double)Math.sqrt((p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y-p2.y))/(double)5;
		double fly = walk >= 10 ? walk - 8 : 12 - walk;
		if(!cannon) return walk;
		return Math.min(walk, fly);   
	}
}
