import java.io.*;

public class N1929 {
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		
		boolean[] prime = new boolean[n+1];
		prime[1] = true;
		
		for (int i=2; i<=Math.sqrt(n); i++) {
			if(!prime[i]) {
				for (int j=2*i; j<=n; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		for (int i=m; i<=n; i++) {
			if(!prime[i]) {
				System.out.println(i);
			}
		}
	}
}