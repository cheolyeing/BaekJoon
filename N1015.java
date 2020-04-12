import java.io.*;
import java.util.*;

public class N1015 {
	static int n;
	static int[] A, B, P;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = new int[n]; B = new int[n]; P = new int[n];
		visited = new boolean[n];
		
		for(int i=0; i<n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = A[i];
		}
		
		Arrays.sort(B);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(A[i]==B[j] && !visited[j]) {
					visited[j] = true;
					P[i] = j;
					break;
				}
			}
		}
		
		for(int i=0; i<n; i++) System.out.print(P[i]+" ");
	}
}