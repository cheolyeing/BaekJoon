import java.io.*;
import java.util.*;

public class N1238 {
	
	static class Node implements Comparable<Node> {
		
		int dest, val;
		
		public Node(int dest, int val) {
			super();
			this.dest = dest;
			this.val = val;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.val - o.val;
		}
	}
	
	static int n, m, x, go[], back[], max;
	static int s, e, v;
	static List<Node> goList[], backList[];
	static final int BIG = 987654321;
	
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		go = new int[n+1];
		back = new int[n+1];
		goList = new List[n+1];
		backList = new List[n+1];
		
		for (int i=1; i<=n; i++) {
			go[i] = BIG;
			back[i] = BIG;
			goList[i] = new ArrayList<>();
			backList[i] = new ArrayList<>();
		}
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			goList[s].add(new Node(e, v));
			backList[e].add(new Node(s, v));
		}
		
		mst(go, goList);
		mst(back, backList);
		
		for (int i=1; i<=n; i++) {
			if(i==x) continue;
			max = Math.max(max, go[i]+back[i]);
		}
		System.out.println(max);
	}
	
	static void mst(int[] arr, List<Node>[] list) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(x,0));
		arr[x] = 0;
		Node temp;
		while(!pq.isEmpty()) {
			temp = pq.poll();
			for(Node n : list[temp.dest]) {
				int num = n.val + temp.val;
				if(arr[n.dest]>num) {
					arr[n.dest] = num;
					pq.offer(new Node(n.dest, num));
				}
			}
		}
	}
	
	/* 나의 첫번째 풀이
	static int n, m, x;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		x = Integer.parseInt(input[2]);
		map = new int[n][n];
		
		for (int i=0; i<m; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			map[a-1][b-1] = Integer.parseInt(input[2]);
		}
		
		for (int k=0; k<n; k++) {
			for (int i=0; i<n; i++) {
				if(i==k) continue;
				for (int j=0; j<n; j++) {
					if(i==j) continue;
					if(map[i][k]>0 && map[k][j]>0) {
						if(map[i][j]==0) map[i][j] = map[i][k]+map[k][j];
						else if(map[i][k]+map[k][j]<map[i][j])
							map[i][j] = map[i][k]+map[k][j];
					}
				}
			}
		}
		
		int answer = 0;
		for (int i=0; i<n; i++) {
			if(map[i][x-1]+map[x-1][i]>answer) answer = map[i][x-1]+map[x-1][i];
		}
		System.out.println(answer);
	}
	
	static void show() {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(map[i][j]+" ");
			} System.out.println();
		}
	}*/
}