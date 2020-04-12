import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2688 {
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int max = 0;
		int[] ans = new int[tc];
		
		for (int i=0; i<tc; i++) {
			int input = Integer.parseInt(br.readLine());
			max = Math.max(max, input);
			ans[i] = input;
		}
		
		int n = max;
		long[][] arr = new long[n+1][10];
		
		for (int i=1; i<=n; i++) {arr[i][0] = 1;}
		for (int i=0; i<10; i++) {arr[1][i] = 1;}
		for (int i=2; i<=n; i++) {
			for (int j=1; j<10; j++) {
				arr[i][j] = (arr[i-1][j] + arr[i][j-1]);
			}
		}
		
		for (int i=0; i<tc; i++) {
			long answer = 0;
			for (int j=0; j<10; j++) {
				answer += arr[ans[i]][j];
			}
			System.out.println(answer);
		}
	}
}