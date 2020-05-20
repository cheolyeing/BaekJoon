import java.io.*;
import java.util.*;

public class N6118 {
	static int n, m;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
		for(int i=0; i<=n; i++) adjList.add(new ArrayList<Integer>());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adjList.get(A).add(B);
			adjList.get(B).add(A);
		}
	}
	
	static void solution() {
		int dist=-1, num=0, cnt=0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1); visited[1] = true;
		while(!q.isEmpty()) {
			num = n+1;
			cnt = q.size();
			for(int i=0; i<cnt; i++) {
				int p = q.poll();
				num = Math.min(num, p);
				for(int v : adjList.get(p)) {
					if(!visited[v]) {
						q.add(v);
						visited[v] = true;
					}
				}
			}
			dist++;
		}
		System.out.println(num+" "+dist+" "+cnt);
	}
}
