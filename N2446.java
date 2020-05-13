import java.io.*;

public class N2446 {
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
		for(int i=n; i>0; i--) {
			for(int j=i; j<n; j++) System.out.print(' ');
			for(int j=0; j<2*i-1; j++) System.out.print('*');
			System.out.println();
		} 
		for(int i=2; i<=n; i++) {
			for(int j=i; j<n; j++) System.out.print(' ');
			for(int j=0; j<2*i-1; j++) System.out.print('*');
			System.out.println();
		}
	}
}
