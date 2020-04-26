import java.io.*;
import java.util.*;

public class SWMae2 {
	static int n, m, ans=0;
	static int[][] ability, relation;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		setting();
		solution();		
	}
	
	public static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ability = new int[n+1][2];
		relation = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			ability[i][0] = Integer.parseInt(st.nextToken());
			ability[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			relation[x][y] = 1;
			relation[y][x] = 1;
		}
	}
	
	public static void solution() {
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				bfs(i);
			}
		}
		System.out.println(ans);
	}
	
	static void bfs(int start) {
		HashSet<Integer> team = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited[start] = true;
		team.add(start);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				int tmp = q.poll();
				for(int j=1; j<=n; j++) {
					if(relation[tmp][j]==1 && !visited[j]) {
						visited[j] = true;
						q.add(j);
						team.add(j);
					}
				}
			}
		}
		ans = Math.max(ans, teamPower(team));
	}
	
	static int teamPower(HashSet<Integer> team) {
		List<Integer> li = new ArrayList<Integer>(team);
		int maxX=1, maxY=1, minX=Integer.MAX_VALUE, minY=Integer.MAX_VALUE;
		
		for(int i=0; i<li.size(); i++) {
			int idx = li.get(i);
			maxX = Math.max(maxX, ability[idx][0]);
			maxY = Math.max(maxY, ability[idx][1]);
			minX = Math.min(minX, ability[idx][0]);
			minY = Math.min(minY, ability[idx][1]);
		}
		
		return 2*(Math.abs(maxX-minX)+Math.abs(maxY-minY));
	}
}
