import java.io.*;
import java.util.*;

public class N1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		int R = Integer.parseInt(input[0]);
		int G = Integer.parseInt(input[1]);
		int B = Integer.parseInt(input[2]);
		
		for (int i=0; i<n-1; i++) {
			input = br.readLine().split(" ");
			int r = Integer.parseInt(input[0]);
			int g = Integer.parseInt(input[1]);
			int b = Integer.parseInt(input[2]);
			r += Math.min(G, B); g += Math.min(R, B); b += Math.min(R, G);
			R = r; G = g; B = b;
		} System.out.println(Math.min(R, Math.min(G, B)));
	}
}