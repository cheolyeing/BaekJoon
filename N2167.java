import java.io.*;

public class N2167 {
	
	static int n, m;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		arr = new int[n+1][m+1];
		
		for (int i=1; i<=n; i++) {
			input = br.readLine().split(" ");
			for (int j=1; j<=m; j++) {
				arr[i][j] = Integer.parseInt(input[j-1]);
				if(j!=1) arr[i][j] += arr[i][j-1];
			}
			
			for (int j=1; j<=m; j++) {
				if(i!=1) arr[i][j] += arr[i-1][j];
			}
		}
		
		//show();
		
		int k = Integer.parseInt(br.readLine());
		
		for (int a=0; a<k; a++) {
			input = br.readLine().split(" ");
			int i = Integer.parseInt(input[0]);
			int j = Integer.parseInt(input[1]);
			int x = Integer.parseInt(input[2]);
			int y = Integer.parseInt(input[3]);
			int answer = arr[x][y]+arr[i-1][j-1]-arr[i-1][y]-arr[x][j-1];
			System.out.println(answer);
		}
	}
	
	static void show() {
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				System.out.print(arr[i][j]+" ");
			} System.out.println();
		}
	}
}
