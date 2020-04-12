import java.io.*;

public class N11057 {
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n+1][10];
		
		for (int i=1; i<=n; i++) {arr[i][0] = 1;}
		for (int i=0; i<10; i++) {arr[1][i] = 1;}
		for (int i=2; i<=n; i++) {
			for (int j=1; j<10; j++) {
				arr[i][j] = (arr[i-1][j] + arr[i][j-1])%10007;
			}
		}
		int ans = 0;
		for (int i=0; i<10; i++) {
			ans += arr[n][i]%10007;
		} 
		
		System.out.println(ans%10007);
	}
}