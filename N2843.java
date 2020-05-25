import java.io.*;
import java.util.*;

public class N2843 {
	static int n, edge[], q, query[][], self[], cycle[], dap[] = new int[300001];
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		setting();
		solution(n, n);
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		edge = new int[n+1];
		self = new int[n+1];
		cycle = new int[n+1];
		visited = new boolean[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			self[i] = i;
			edge[i] = Integer.parseInt(st.nextToken());
		}
		
		q = Integer.parseInt(br.readLine());
		query = new int[q][2];
		for(int i=q-1; i>=0; i--) {
			st = new StringTokenizer(br.readLine());
			query[i][0] = Integer.parseInt(st.nextToken());
			query[i][1] = Integer.parseInt(st.nextToken());
			if(query[i][0]==2) visited[query[i][1]] = true;
		}
		
	}
	
	static void solution(int c, int node) {
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				union(i, edge[i]);
			}
		}
		int cnt = 0;
		for(int i=0; i<q; i++) {
			if(query[i][0]==2) {
				union(query[i][1], edge[query[i][1]]);
			} else {
				int x = find(query[i][1]);
				if(cycle[x]==0) dap[cnt] = x;
				else dap[cnt] = -1;
				cnt++;
			}
		}
		for(int i=cnt-1; i>=0; i--) {
			if(dap[i]==-1) System.out.println("CIKLUS");
			else System.out.println(dap[i]);
		}
	}
	
	static int find(int u) {
		if(u==self[u]) return u;
		return self[u] = find(self[u]);
	}
	
	static void union(int u, int v) {
		if(u==0 || v==0) return;
		u = find(u); 
		v = find(v);
		if(u==v) cycle[v] = 1;
		else self[u] = v;
	}
}
