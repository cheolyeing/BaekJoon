import java.io.*;
import java.util.*;

public class N1005 {
	static int n, k, target;
	static int[] time;
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t=0; t<tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			time = new int[n+1];
			int[] cnt = new int[n+1];
			ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<=n; i++) graph.add(new ArrayList<Integer>());
			for(int i=1; i<=n; i++) time[i] = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
				cnt[b]++;				
			}
			target = Integer.parseInt(br.readLine());
			System.out.println(topologicalSort(graph, cnt));
		}
	}
	
	static int topologicalSort(ArrayList<ArrayList<Integer>> graph, int[] cnt) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] totalTime = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			totalTime[i] = time[i];
			if(cnt[i]==0) {
				q.add(i);
			}
		}
		
		Loop :
		while(!q.isEmpty()) {
			int v = q.poll();
			
			for(int nextV : graph.get(v)) {
				totalTime[nextV] = Math.max(totalTime[nextV], totalTime[v]+time[nextV]);
				cnt[nextV]--;
				if(cnt[nextV]==0) {
					if(nextV==target) break Loop;
					q.add(nextV);
				}
			}
		}
		return totalTime[target];
	}
}
