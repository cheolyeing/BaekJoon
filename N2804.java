import java.io.*;
import java.util.Arrays;

public class N2804 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		String word1 = input[0];
		String word2 = input[1];
		
		char[] array1 = word1.toCharArray();
		char[] array2 = word2.toCharArray();
		
		int N = word1.length();
		int M = word2.length();
		
		char[][] answer = new char[M][N];
		for (char[] row: answer)
		    Arrays.fill(row, '.');
		
		int idx1 = 0, idx2 = 0;
		boolean out = false;
		for (int i=0; i<N; i++) { 
			if(out) {break;}
			for (int j=0; j<M; j++) { 
				if(array1[i]==array2[j]) { idx1=i; idx2=j; out = true; break; }
			}
		}
		
		int idx = 0;
		for (char c : array1) {
			answer[idx2][idx] = c; idx++;
		} idx = 0;
		for (char c : array2) {
			answer[idx][idx1] = c; idx++;
		}
		
		for (int i=0; i<M; i++) {
			for (int j=0; j<N; j++) {
				sb.append(answer[i][j]);
			} sb.append("\n");
		}
		
		System.out.println(sb);
	}
}