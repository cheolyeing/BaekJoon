import java.io.*;
import java.util.*;

public class N12100 {
	static int n, ans=0;
	static int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(board);
	}
	
	static int[][] push(int dir, int[][] board) { // го ╩С ©Л аб
		int[][] nboard = new int[n][n];
		
		for (int i=0; i<n; i++) {
			LinkedList<Integer> tmp = new LinkedList<Integer>();
			for (int j=0; j<n; j++) {
				if(dir==0 || dir==1) {
					if(board[j][i]!=0) tmp.add(board[j][i]); // |
				} else if(board[i][j]!=0) tmp.add(board[i][j]); // ╓я
			}
			
			if(dir==0) {
				int idx = n-1;
				while(!tmp.isEmpty()) nboard[idx--][i] = tmp.pollLast();
			} else if(dir==1) {
				int idx = 0;
				while(!tmp.isEmpty()) nboard[idx++][i] = tmp.poll();
			} else if(dir==2) {
				int idx = n-1;
				while(!tmp.isEmpty()) nboard[i][idx--] = tmp.pollLast();
			} else {
				int idx = 0;
				while(!tmp.isEmpty()) nboard[i][idx++] = tmp.poll();
			}
		}
		
		return nboard;
	}
	
	static int[][] merge(int dir, int[][] board) {
		//int[][] nboard = new int[n][n];
		
		for (int i=0; i<n; i++) {
			if(dir==0) {
				int idx=n-1;
				while(idx>0) {
					if(board[idx][i]==board[idx-1][i]) {
						board[idx][i]*=2; board[idx-1][i]=0;
					} idx--;
				}
			} else if(dir==1) {
				int idx = 0;
				while(idx<n-1) {
					if(board[idx][i]==board[idx+1][i]) {
						board[idx][i]*=2; board[idx+1][i]=0;
					} idx++;
				}
			} else if(dir==2) {
				int idx=n-1;
				while(idx>0) {
					if(board[i][idx]==board[i][idx-1]) {
						board[i][idx]*=2; board[i][idx-1]=0;
					} idx--;
				}
			} else {
				int idx = 0;
				while(idx<n-1) {
					if(board[i][idx]==board[i][idx+1]) {
						board[i][idx]*=2; board[i][idx+1]=0;
					} idx++;
				}
			}
		}
		
		return push(dir, board);
	}
	
	static void showArray(int[][] board) {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(board[i][j]+" ");
			} System.out.println();
		} System.out.println("------------");
	}
	
	static void bfs(int[][] board) {
		Queue<int[][]> q = new LinkedList<int[][]>();
		q.add(board);
		int time = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			if (time==5) {
				for (int i=0; i<size; i++) {
					ans = Math.max(ans,  max(q.poll()));
				}
				break;
			}
			
			for (int i=0; i<size; i++) {
				int[][] b = q.poll();
				
				for (int k=0; k<4; k++) {
					int[][] nb = merge(k, push(k, b));
					q.add(nb);
				}
			} time++;
		}
		System.out.println(ans);
	}
	
	static int max(int[][] b) {
		int m = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if(m<b[i][j]) m = b[i][j];
			}
		}
		return m;
	}
}