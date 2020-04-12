import java.io.*;
import java.util.Arrays;

public class N10809 {
	
	static int[] alpha = new int[26];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Arrays.fill(alpha, -1);
		
		for (int i=0; i<input.length(); i++) {
			int idx = input.charAt(i)-97;
			if(alpha[idx]==-1) {
				alpha[idx] = i;
			}
		} printArray(alpha);
	}
	
	static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i+" ");
		} System.out.println();
	}
}