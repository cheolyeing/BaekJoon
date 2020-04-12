import java.io.*;

public class N11726 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int a = 1;
		int b = 1;
		for (int i=1; i<n; i++) {
			int tmp = b;
			b = (a+b)%10007;
			a = tmp;
		} System.out.println(b);
	}
}