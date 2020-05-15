import java.io.*;

public class N1789 {
	static long n;
	public static void main(String[] args) throws IOException {
		setting();
		System.out.println(solution());
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Long.parseLong(br.readLine());
	}
	
	static long solution() {
		if(n==1) return 1;
		for(long i=1; i<=n; i++) {
			if(n<i*(i+1)/2) return i-1;
		}
		return 0;
	}
}
