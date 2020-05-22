import java.io.*;
import java.util.*;

public class N1967 {
	static int n, maxDist;
	static boolean[] visited;
	static Node maxDistNode;
	static LinkedList<Node> tree[];
	static class Node {
		int num, dist;
		public Node(int num, int dist) {
			this.num = num;
			this.dist = dist;
		}
	}
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tree = new LinkedList[n+1];
		visited = new boolean[n+1];
		for(int i=1; i<=n; i++) tree[i] = new LinkedList<Node>();
		for(int i=0; i<n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			tree[p].add(new Node(c, d));
			tree[c].add(new Node(p, d));
		}
	}
	
	static void solution() {
		for(Node root : tree[1]) {
			visited[1] = true;
			dfs(root, root.dist);
			visited[1] = false;
		}
		maxDist = 0;
		dfs(maxDistNode, 0);
		System.out.println(maxDist);
	}
	
	static void dfs(Node curNode, int dist) {
		visited[curNode.num] = true;
		for(Node tmp : tree[curNode.num]) {
			if(!visited[tmp.num]) {
				visited[tmp.num] = true;
				dfs(tmp, dist+tmp.dist);
				visited[tmp.num] = false; 
			}
		}
		if(dist>maxDist) {
			maxDistNode = curNode;
			maxDist = dist;
		}
		visited[curNode.num] = false;
	}
}
