import java.io.*;
import java.util.*;

public class N11724 {
	
	static int[][] Graph;
	static boolean[] visit;
	static int edge;
	static int vertice;
	static int numOfVisit = 0;
	static int result = 0;
	static Queue<Integer> q = new LinkedList<Integer>();
	
	static void bfs() {
		if(q.isEmpty()) { return; }
		int tmp = q.poll();
		
		for (int i=0; i<vertice; i++) {
			if(!visit[i] && Graph[tmp][i]==1) {
				visit[i]=true; q.add(i); numOfVisit++;
			}
		} bfs();
		
	}
	
	static void setting() {
		for (int i=0; i<vertice; i++) { visit[i]=false;
			for (int j=0; j<vertice; j++) {
				Graph[i][j]=0;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		vertice = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		Graph = new int[vertice][vertice]; visit = new boolean[vertice];
		setting();
		
		for (int i=0; i<edge; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			a--; b--; Graph[a][b]=1; Graph[b][a]=1;
		}
		
		while(!(numOfVisit==vertice)) {
			for(int i=0; i<vertice; i++) {
				if(!visit[i]) {
					result++;
					q = new LinkedList<Integer>();
					q.add(i); visit[i]=true; numOfVisit++;
					bfs();
				}
			}
		} System.out.println(result);
	}
}