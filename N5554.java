import java.io.*;

public class N5554 {
	static int sum=0;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<4; i++) sum += Integer.parseInt(br.readLine());
	}
	
	static void solution() {
		int m = sum/60;
		int s = sum%60;
		System.out.println(m);
		System.out.println(s);
	}
}
