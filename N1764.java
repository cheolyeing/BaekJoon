import java.io.*;
import java.util.*;

public class N1764 {
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		String[] all = new String[n+m];
		
		for (int i=0; i<n+m; i++) {
			all[i] = br.readLine();		
		}
		
		Arrays.sort(all);
		
		int answer = 0;
		String[] ans = new String[n];
		
		for (int i=0; i<n+m-1; i++) {
			if(all[i].equals(all[i+1])) {
			ans[answer] = all[i]; answer++; 
			}
		}
		
		System.out.println(answer);
		for (int i=0; i<answer; i++) {
			System.out.println(ans[i]);
		}	
	}
}