import java.io.*;

public class N2010 {
	static int n;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for (int i=0; i<n; i++) {
			answer += Integer.parseInt(br.readLine());
		}
		
		System.out.println(answer+1-n);
	}
}