import java.io.*;
import java.util.*;

public class N1753 {
	
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
	
	static int v, e, k, go[], back[];
	static List<Node> goList[], backList[];
	static int dep, dest, w;
	static final int BIG = 987654321;
	
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		go = new int[v+1];
		back = new int[v+1];
		goList = new List[v+1];
		backList = new List[v+1];
		
		for (int i=1; i<=v; i++) {
			go[i] = BIG;
			back[i] = BIG;
			goList[i] = new ArrayList<>();
			backList[i] = new ArrayList<>();
		}
		
		for (int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			dep = Integer.parseInt(st.nextToken());
			dest = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			goList[dep].add(new Node(dest, w));
			backList[dest].add(new Node(dep, w));
		}
		
		mst(go, goList);
		//mst(back, backList);
		
		for (int i=1; i<=v; i++) {
			System.out.println(go[i]==BIG?"INF":go[i]);
		}
	}
	
	static void mst(int[] arr, List<Node>[] list) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(k,0));
		arr[k] = 0;
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
}