import java.util.*;

public class N1697 {
	static boolean[] visited = new boolean[100001];
	static int n, k, answer=0;
	public static void main(String[] v) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		bfs();
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		int ans = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i=0; i<size; i++) {
				int pos = q.poll();
				if(pos==k) {
					System.out.println(ans); System.exit(0);
				}
				visited[pos] = true;
				int[] np = {pos-1, pos+1, 2*pos};
				for (int k=0; k<3; k++) {
					if(np[k]>=0 && np[k]<=100000 && !visited[np[k]]) {
						q.add(np[k]);
					}
				}
			}
			ans++;
		}
	}
}