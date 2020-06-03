import java.io.*;
import java.util.*;

public class N6086 {
	static int n;
	static int[][] capacity = new int[52][52];
	static int[][] flow = new int[52][52];
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		for(int i=0; i<52; i++) adj.add(new ArrayList<Integer>());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = charInverter(st.nextToken().charAt(0));
			int b = charInverter(st.nextToken().charAt(0));
			int val = Integer.parseInt(st.nextToken());
			capacity[a][b] += val;
			capacity[b][a] += val;
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
	}
	
	static void solution() {
		int ans = 0, S = 0, T = 25;
		
		while(true) {
			int[] prev = new int[52];
			Arrays.fill(prev, -1);
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(S);
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				for(int i=0; i<adj.get(cur).size(); i++) {
					int next = adj.get(cur).get(i);
					if(prev[next]!=-1) continue;
					if(capacity[cur][next] - flow[cur][next] > 0) {
						q.add(next);
						prev[next] = cur;
						if(next==T) break;
					}
				}
			}
			
			if(prev[T]==-1) break;
			
			int F = Integer.MAX_VALUE;
			
			for(int i=T; i!=S; i=prev[i]) {
				F = Math.min(F, capacity[prev[i]][i] - flow[prev[i]][i]);
			}
			
			for(int i=T; i!=S; i=prev[i]) {
				flow[prev[i]][i] += F;
				flow[i][prev[i]] -= F;
			}
			
			ans += F;
		}
		System.out.println(ans);
	}
	
	static int charInverter(char c) {
		if((int)c>96) return (int)c - 71;
		else return (int)c - 65;
	}
}
