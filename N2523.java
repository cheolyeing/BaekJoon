import java.io.*;

public class N2523 {
	static int n;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
	}
	
	static void solution() {
		for(int i=1; i<=n; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			} System.out.println();
		}
		for(int i=n-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			} System.out.println();
		}
	}
}
