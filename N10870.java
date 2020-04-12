import java.io.*;

public class N10870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(fibonachi(n));
	}
	
	static int fibonachi(int n) {
		if(n==1) {
			return 1;
		} else if(n==2) {
			return 1;
		} else if(n==0) {
			return 0;
		} else {
			return fibonachi(n-1)+fibonachi(n-2);
		}
	}
}