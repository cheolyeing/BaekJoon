import java.io.*;
import java.util.*;

public class N16235 {
	static int n, m, k;
	static int[][] map, add;
	static int[][] adj = {{1,0},{1,1},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1}};
	static class Tree implements Comparable<Tree> {
		boolean live;
		int age;
		public Tree(int age) {
			this.age = age; this.live = true;
		}
		
		@Override
		public int compareTo(Tree t) {
			if(this.age > t.age) return 1;
			else if(this.age < t.age) return -1;
			else return 0;
		}
	}
	static ArrayList[][] trees;
	
	public static void main(String[] args) throws IOException {
		setting();
		System.out.println(solution());
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		add = new int[n+1][n+1];
		trees = new ArrayList[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			Arrays.fill(map[i], 5);
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				trees[i][j] = new ArrayList<Tree>();
				add[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			trees[x][y].add(new Tree(age));
		}
	}
	
	static void spring() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				int size = trees[i][j].size();
				if(size>0) Collections.sort(trees[i][j]);
				for(int s=0; s<size; s++) {
					Tree t = (Tree) trees[i][j].get(s);
					if(map[i][j]>=t.age) {
						map[i][j] -= t.age;
						t.age++;
					} else t.live = false;
				}
			}
		}
	}
	
	static void summer() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				int size = trees[i][j].size();
				for(int s=0; s<size; s++) {
					Tree t = (Tree) trees[i][j].get(s);
					if(!t.live) {
						while(s<trees[i][j].size()) {
							t = (Tree) trees[i][j].get(s);
							map[i][j] += t.age / 2;
							trees[i][j].remove(s);
						}
						break;
					}
				}
			}
		}
	}
	
	static void fall() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				int size = trees[i][j].size();
				for(int s=0; s<size; s++) {
					Tree t = (Tree) trees[i][j].get(s);
					if(t.age%5==0) {
						for(int k=0; k<8; k++) {
							int nx = i+adj[k][0];
							int ny = j+adj[k][1];
							if(inRange(nx, ny)) {
								trees[nx][ny].add(new Tree(1));
							}
						}
					}
				}
			}
		}
	}
	
	static void winter() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				map[i][j] += add[i][j];
			}
		}
	}
	
	static boolean inRange(int x, int y) {
		return (x>=1 && x<=n && y>=1 && y<=n);
	}
	
	static int solution() {
		int answer = 0;
		for(int i=0; i<k; i++) {
			spring(); summer(); fall(); winter(); //showTree(); //showArr(map);
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				answer += trees[i][j].size();
			}
		}
		
		return answer;
	}
	
	static void showTree() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(trees[i][j].size()+" ");
			} System.out.println();
		} System.out.println("------------");
	}
	
	static void showArr(int[][] arr) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(arr[i][j]+" ");
			} System.out.println();
		} System.out.println("--------------");
	}
}