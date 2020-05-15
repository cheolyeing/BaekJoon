import java.io.*;

public class N5597 {
	static boolean[] submit = new boolean[31];
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<28; i++) {
			submit[Integer.parseInt(br.readLine())] = true;
		}
	}
	
	static void solution() {
		for(int i=1; i<31; i++) {
			if(!submit[i]) System.out.println(i);
		}
	}
}
