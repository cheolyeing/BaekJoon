import java.io.*;

public class N1614 {
	static int[] arr = {1, 2, 3, 4, 5, 4, 3, 2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(br.readLine());
		long cnt = Integer.parseInt(br.readLine());
		long n = N - 1;
		if (cnt > 0) {
			if (N % 4 == 1) n += 8 * cnt; 
			else n += cnt / 2 * 8 + cnt % 2 * (8 - (N - 1) * 2); 
		}
		System.out.println(n);
	}
}