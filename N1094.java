import java.io.*;

public class N1094 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		while(n!=0) {
			result += n%2;
			n /= 2;
		} System.out.println(result);
	}
}