import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1476 {
	
	static int E = 0; // 15
	static int S = 0; // 28
	static int M = 0; // 19
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int e = Integer.parseInt(input[0]);
		int s = Integer.parseInt(input[1]);
		int m = Integer.parseInt(input[2]);
		
		for (int i=1; i<8000; i++) {
			E++; S++; M++;
			if(E>15) { E=1; }
			if(S>28) { S=1; }
			if(M>19) { M=1; }
			if(E==e && S==s && M==m) {
				System.out.println(i); System.exit(0);
			}
		}
	}
}
