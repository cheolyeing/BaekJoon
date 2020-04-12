import java.io.*;
import java.util.Arrays;

public class N11055 {
	
	static int n;
	static int[] subsequence;
	static int[] add;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		subsequence = new int[n];
		add = new int[n];
		
		String[] input = br.readLine().split(" ");
		
		for (int i=0; i<n; i++) {
			subsequence[i] = Integer.parseInt(input[i]);
		}
	}
	
	static void solution() {
		for (int i=0; i<n; i++) {
			add[i] = subsequence[i];
			for (int j=0; j<i; j++) {
				if(subsequence[j]<subsequence[i] && add[i]<add[j]+subsequence[i]) add[i] = add[j] + subsequence[i];
			if(answer<add[i]) answer = add[i];	
			}
		}
		System.out.println(answer>subsequence[0]?answer:subsequence[0]);
	}
}