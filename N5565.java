import java.io.*;

public class N5565 {
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<9; i++) n -= Integer.parseInt(br.readLine());
		System.out.println(n);
	}
	
	static void solution() {
		
	}
}
