import java.io.*;
import java.util.*;

public class N10282 {
	static final int INF = Integer.MAX_VALUE;
	static int n, d, c, time[];
	static ArrayList<ArrayList<Pair>> com;
	static class Pair implements Comparable<Pair> {
		int idx, cost;
		public Pair(int a, int s) {
			this.idx = a; this.cost = s;
		}
		@Override
		public int compareTo(Pair p) {
			// TODO Auto-generated method stub
			return this.cost - p.cost;
		}
	}
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			time = new int[n+1];
			Arrays.fill(time, INF);
			com = new ArrayList<ArrayList<Pair>>();
			
			for(int i=0; i<=n; i++) com.add(new ArrayList<Pair>());
			for(int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				com.get(b).add(new Pair(a, s));
			}
			dijkstra();
		}
	}
	
	static void solution() {
		
	}
	
	static void dijkstra() {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		time[c] = 0;
		pq.add(new Pair(c, 0));
		
		while(!pq.isEmpty()) {
			Pair from = pq.poll();
			
			if(from.cost > time[from.idx]) continue;
			for(Pair to : com.get(from.idx)) {
				if(time[to.idx] > time[from.idx] + to.cost) {
					time[to.idx] = time[from.idx] + to.cost;
					pq.add(new Pair(to.idx, time[to.idx]));
				}
			}
		}
		
		int cnt=0, max=0;
		for(int i=1; i<=n; i++) {
			if(time[i]!=INF) {
				cnt++;
				max = Math.max(max, time[i]);
			}
		}
		System.out.println(cnt+" "+max);
	}
}
