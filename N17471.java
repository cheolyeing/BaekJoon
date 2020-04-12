import java.io.*;
import java.util.*;

public class N17471 {
	
	static int n;
	static int[] population;
	static boolean[] visited;
	static ArrayList<Integer>[] adjList;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		setting();
		
		for (int i=1; i<=n/2; i++) {
			int[] group = new int[i];
			backTracking(0, 0, i, group);
		}
		System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);
	}
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		adjList = new ArrayList[n+1];
		population = new int[n+1];
		visited = new boolean[n+1];
		
		String[] input = br.readLine().split(" ");
		for (int i=1; i<=n; i++) {
			population[i] = Integer.parseInt(input[i-1]);
		}
		
		for (int i=1; i<=n; i++) {
			input = br.readLine().split(" ");
			adjList[i] = new ArrayList<Integer>();
			for (int j=1; j<=Integer.parseInt(input[0]); j++) {
				adjList[i].add(Integer.parseInt(input[j]));
			}
		}
	}
	
	static void backTracking(int idx, int bef, int num, int[] group) {
		if(idx==num) {
			answer(group); return;
		}
		
		for(int i=bef+1; i<=n; i++) {
			group[idx] = i;
			backTracking(idx+1, i, num, group);
		}
	}
	
	static void answer(int[] group) {
		
		int[] first = group;
		int[] second = second(group);
		
		resetVisited();
		int a = bfs(first[0],first);
		if(isConnected(first)) {
			resetVisited();
			int b = bfs(second[0], second);
			if(isConnected(second)) {
				int res = Math.abs(a-b);
				if(answer>res) answer = res;
			} else return;
		} else return;
	}
	
	static void resetVisited() {
		Arrays.fill(visited, false);
	}
	
	static boolean isConnected(int[] group) {
		for (int i=0; i<group.length; i++) {
			if(!visited[group[i]]) {
				return false;
			}
		}
		return true;
	}
	
	static int bfs(int v, int[] group) {
		int sum = 0;
		
		Queue q = new LinkedList<Integer>();
		q.add(v);
		
		while(!q.isEmpty()) {
			int idx = (int)q.poll();
			sum += population[idx];
			visited[idx] = true;
			ArrayList<Integer> tmp = adjList[idx];
			
			for (int i=0; i<tmp.size(); i++) {
				boolean isFind = false;
				int adjV = tmp.get(i);
				for (int k=0; k<group.length; k++) {
					if(adjV==group[k]) {
						isFind = true;
						break;
					}
				}
				if(isFind && !visited[adjV]) {
					q.add(adjV);
					visited[adjV] = true;
				}
			}
		}
		return sum;
	}
	
	static int[] second(int[] group) {
		int[] second = new int[n-group.length];
		int idx = 0;
		
		for(int i=1; i<=n; i++) {
			boolean exist = false;
			
			for(int j=0; j<group.length; j++) {
				if(i==group[j]) {
					exist = true;
					break;
				}
			}
			if(!exist) {
				second[idx++] = i;
			}
		}
		return second;
	}
}