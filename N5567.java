import java.io.*;

public class N5567 {
	
	static int n;
	static boolean[][] friend;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		friend = new boolean[n+1][n+1];
		
		int list = Integer.parseInt(br.readLine());
		
		for (int i=0; i<list; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			friend[a][b] = true;
			friend[b][a] = true;
		}
		
		boolean[] invite = new boolean[n+1];
		
		for (int i=2; i<=n; i++) {
			if(friend[1][i]) {
				if(!invite[i]) {
					answer++; invite[i] = true;
				}
				for (int j=2; j<=n; j++) {
					if(friend[i][j] && !invite[j]) {
						invite[j] = true; answer++;
					}
				}
			}
		}
		System.out.println(answer);
	}
}