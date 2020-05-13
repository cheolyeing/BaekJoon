import java.io.*;

public class N10996 {
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
		for(int i=0; i<2*n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print((i+j)%2==0 ? '*':' ');
			}
			System.out.println();
		}
	}
}
