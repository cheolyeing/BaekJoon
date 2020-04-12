import java.io.*;

public class N1547 {
	static int m;
	static int ans = 1;
	public static void main(String[] args) throws IOException {
		setting();
		System.out.println(ans);
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = Integer.parseInt(br.readLine());
		for (int i=0; i<m; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			if(a==ans) {
				ans = b;
			} else if(b==ans) {
				ans = a;
			}
		}
	}
}