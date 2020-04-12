import java.io.*;

public class N11404 {
	
	static int n;
	static int m;
	static int[][] bus;
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
		show();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		bus = new int[n][n];
		
		for (int i=0; i<m; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int price = Integer.parseInt(s[2]);
			if(bus[a-1][b-1]==0 || (bus[a-1][b-1]!=0 && bus[a-1][b-1]>price))
			bus[a-1][b-1] = price;
		}
	}
	
	static void solution() {
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				if(i==k) continue;
				for(int j=0; j<n; j++) {
					if(i==j) continue;
					if(bus[i][k]!=0 && bus[k][j]!=0) {
						if(bus[i][j]==0) {
							bus[i][j] = bus[i][k]+bus[k][j];
						} else {
							if(bus[i][j]>bus[i][k]+bus[k][j]) {
								bus[i][j] = bus[i][k]+bus[k][j];
							}
						}
					}
				}
			}
		}
	}
	
	static void show() {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(bus[i][j]+" ");
			} System.out.println();
		}
	}
}