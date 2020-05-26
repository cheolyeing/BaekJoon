import java.io.*;
import java.util.*;

public class Standard {
	static int n, d, c, time[], ans;
	static boolean[] visited;
	static ArrayList<ArrayList<Pair>> com;
	static class Pair implements Comparable<Pair> {
		int a, b, s;
		public Pair(int a, int b, int s) {
			this.a = a; this.b = b; this.s = s;
		}
		@Override
		public int compareTo(Pair p) {
			// TODO Auto-generated method stub
			return this.s - p.s;
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
			ans = 0;
			time = new int[n+1];
			Arrays.fill(time, Integer.MAX_VALUE);
			visited = new boolean[n+1];
			com = new ArrayList<ArrayList<Pair>>();
			for(int i=0; i<=n; i++) com.add(new ArrayList<Pair>());
			for(int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				com.get(b).add(new Pair(a, b, s));
			}
			dijkstra();
		}
	}
	
	static void solution() {
		
	}
	
	static void dijkstra() {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		visited[c] = true;
		time[c] = 0;
		
		int t = 0;
		for(Pair p : com.get(c)) pq.add(p);
		
		while(!pq.isEmpty()) {
			Pair tmp = pq.poll();
			time[tmp.a] = Math.min(time[tmp.a], time[tmp.b]+tmp.s);
			if(visited[tmp.a]) continue;
			else {
				visited[tmp.a] = true;
				for(Pair p : com.get(tmp.a)) pq.add(p);
			}
		}
		
		int cnt=0, max=0;
		for(int i=1; i<=n; i++) {
			if(visited[i]) {
				max = Math.max(max, time[i]);
				cnt++;
			}
		}
		System.out.println(cnt+" "+max);
	}
}
