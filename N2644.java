import java.io.*;
import java.util.*;

public class N2644 {
	
	static int[][] family;
	static boolean[] visit;
	static int n;
	static int person1, person2;
	static Queue<Integer> q = new LinkedList<Integer>();
	static int result = -1;
	
	static void setting() {
		for (int i=0; i<n; i++) {
			visit[i] = false;
			for (int j=0; j<n; j++) {
				family[i][j]=0;
			}
		}
	}
	
	static void bfs() {
		if(q.isEmpty()) { System.out.println(-1); return; }
		
		int len = q.size();
		result ++;

		for (int i=0; i<len; i++) {
			int tmp = q.poll();
			if(tmp==person2-1) { System.out.println(result); return; }
			for (int j=0; j<n; j++) {
				if( !visit[j] && family[tmp][j]==1 ) {
					visit[j] = true;
					q.add(j);
				}
			}
		} bfs();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		family = new int[n][n]; visit = new boolean[n];
		setting();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		person1 = Integer.parseInt(st.nextToken());
		person2 = Integer.parseInt(st.nextToken());
		
		if(person1 == person2) { System.out.println(0); return; }
		
		int relation = Integer.parseInt(br.readLine());
		for (int i=0; i<relation; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			family[a-1][b-1] = 1; family[b-1][a-1] = 1;
		} 
		q.add(person1-1);
		visit[person1-1] = true;
		bfs();
	}
}