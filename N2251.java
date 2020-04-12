import java.io.*;
import java.util.*;

public class N2251 {
	static int a, b, c;
	static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		visited = new boolean[a+1][b+1][c+1];
		bfs();
		
		for (int C=0; C<=c; C++) {
			for (int B=0; B<=b; B++) {
				if(visited[0][B][C]) {
					System.out.print(C+" "); break;
				}
			}				
		}
	}
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		int[] first = {0, 0, c};
		q.add(first);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i=0; i<size; i++) {
				int[] water = q.poll();
				visited[water[0]][water[1]][water[2]] = true;
				
				if(water[0]!=a) {
					if(water[1]!=0) {
						if(a-water[0]>=water[1]) {
							int[] tmp = {water[0]+water[1], 0, water[2]};
							if(!visited[tmp[0]][tmp[1]][tmp[2]]) q.add(tmp);
						} else {
							int[] tmp = {a, water[1]-(a-water[0]), water[2]};
							if(!visited[tmp[0]][tmp[1]][tmp[2]]) q.add(tmp);
						}
					}
					if(water[2]!=0) {
						if(a-water[0]>=water[2]) {
							int[] tmp = {water[0]+water[2], water[1], 0};
							if(!visited[tmp[0]][tmp[1]][tmp[2]]) q.add(tmp);
						} else {
							int[] tmp = {a, water[1], water[2]-(a-water[0])};
							if(!visited[tmp[0]][tmp[1]][tmp[2]]) q.add(tmp);
						}
					}
				}
				if(water[1]!=b) {
					if(water[0]!=0) {
						if(b-water[1]>=water[0]) {
							int[] tmp = {0, water[0]+water[1], water[2]};
							if(!visited[tmp[0]][tmp[1]][tmp[2]]) q.add(tmp);
						} else {
							int[] tmp = {water[0]-(b-water[1]), b, water[2]};
							if(!visited[tmp[0]][tmp[1]][tmp[2]]) q.add(tmp);
						}
					}
					if(water[2]!=0) {
						if(b-water[1]>=water[2]) {
							int[] tmp = {water[0], water[1]+water[2], 0};
							if(!visited[tmp[0]][tmp[1]][tmp[2]]) q.add(tmp);
						} else {
							int[] tmp = {water[0], b, water[2]-(b-water[1])};
							if(!visited[tmp[0]][tmp[1]][tmp[2]]) q.add(tmp);
						}
					}
				}
				if(water[2]!=c) {
					if(water[0]!=0) {
						if(c-water[2]>=water[0]) {
							int[] tmp = {0, water[1], water[0]+water[2]};
							if(!visited[tmp[0]][tmp[1]][tmp[2]]) q.add(tmp);
						} else {
							int[] tmp = {water[0]-(c-water[2]), water[1], c};
							if(!visited[tmp[0]][tmp[1]][tmp[2]]) q.add(tmp);
						}
					}
					if(water[1]!=0) {
						if(c-water[2]>=water[1]) {
							int[] tmp = {water[0], 0, water[1]+water[2]};
							if(!visited[tmp[0]][tmp[1]][tmp[2]]) q.add(tmp);
						} else {
							int[] tmp = {water[0], water[1]-(c-water[2]), c};
							if(!visited[tmp[0]][tmp[1]][tmp[2]]) q.add(tmp);
						}
					}
				}
			}
		}
	}
}