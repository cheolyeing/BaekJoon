import java.io.*;
import java.util.*;

public class N10707 {
	static int A, B, C, D, P; 
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = Integer.parseInt(br.readLine());
		B = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		D = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
	}
	
	static void solution() {
		int X = A*P;
		int Y = B;
		if(P>C) Y += D*(P-C);
		System.out.println(Math.min(X, Y));
	}
}
