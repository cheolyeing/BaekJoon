import java.io.*;

public class N11048 {
	
	static int n, m;
	static int[][] candy;
	
	public static void main(String[] args) throws IOException {
		setting();
		dp();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		candy = new int[n][m];
		
		for (int i=0; i<n; i++) {
			input = br.readLine().split(" ");
			for (int j=0; j<m; j++) {
				candy[i][j] = Integer.parseInt(input[j]);
			}
		}
	}
	
	static void dp () {
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				int x = n-i-1;
				int y = m-j-1;
				
				if(x+1==n && y+1==m) {
					continue;
				} else if(x+1==n) {
					candy[x][y] += candy[x][y+1];
				} else if(y+1==m) {
					candy[x][y] += candy[x+1][y];
				} else {
					candy[x][y] += Math.max(candy[x+1][y], candy[x][y+1]);
				}
				
			}
		} System.out.println(candy[0][0]);
	}
}