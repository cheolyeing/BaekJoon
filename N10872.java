import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10872 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(Fact(n));
	}
	
	static int Fact(int n) {
		if(n==0) {
			return 1;
		} else {
			return n * Fact(n-1);
		}
	}
}