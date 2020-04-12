import java.io.*;

public class N1507 {
	
	static int n;
	static int[][] map;
	static int[][] answer;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
		System.out.println(showAnswer());
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n]; answer = new int[n][n];
		visit = new boolean[n];
		
		for (int i=0; i<n; i++) {
			String[] s = br.readLine().split(" ");
			
			for (int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				answer[i][j] = map[i][j];
			}
		}
	}
	
	static void solution () {
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				if(canGo(i,j)) {answer[i][j]=0;}
			}
		}
	}
	
	static boolean canGo(int a, int b) {
		
		for(int i=0; i<n; i++) {
			if(i!=a && i!=b) {
				if(price(a,i,b)==map[a][b]) return true;
				else if(price(a,i,b)<map[a][b]) {System.out.println(-1); System.exit(0);} 
			}
		}
		
		return false;
	}
	
	static int price(int a, int b, int c) {
		return map[a][b]+map[b][c];
	}
	
	static int showAnswer() {
		int ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				ans += answer[i][j];
			}
		}
		return ans;
	}
}