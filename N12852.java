import java.io.*;
import java.util.*;

public class N12852 {
	static int n;
	static boolean[] visited;
	static class Node {
		String operator;
		int num;
		public Node(String operator, int num) {
			this.operator = operator;
			this.num = num;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		bfs();
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node("", n)); 
		visited[n] = true;
		
		while(!q.isEmpty()) {
			int s = q.size();
			for(int i=0; i<s; i++) {
				Node tmp = q.poll();
				if(tmp.num==1) {
					System.out.println(tmp.operator.length());
					System.out.print(n+" ");
					for(int j=0; j<tmp.operator.length(); j++) {
						if(tmp.operator.charAt(j)=='3') n /= 3;
						else if(tmp.operator.charAt(j)=='2') n /= 2;
						else n -= 1;
						System.out.print(n+" ");
					}
					System.exit(0);
				}
				if(tmp.num%3==0 && !visited[tmp.num/3]) {
					visited[tmp.num/3] = true;
					q.add(new Node(tmp.operator+"3", tmp.num/3));
				}
				if(tmp.num%2==0 && !visited[tmp.num/2]) {
					visited[tmp.num/2] = true;
					q.add(new Node(tmp.operator+"2", tmp.num/2));
				}
				if(tmp.num>1 && !visited[tmp.num-1]) {
					visited[tmp.num-1] = true;
					q.add(new Node(tmp.operator+"1",  tmp.num-1));
				}
			}
		}
	}
}