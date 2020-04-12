import java.io.*;
import java.util.*;

public class N1157 {
	
	static int[] alpha = new int[26];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Arrays.fill(alpha, 0);
		
		for(int i=0; i<input.length(); i++) {
			int idx = input.charAt(i);
			if(idx<=90) {
				idx -= 65;
			} else { idx -= 97; }
			alpha[idx]++;
		} int ans = MostAppear(alpha);
		if(ans==-1) {System.out.println("?");}
		else {System.out.println((char)(ans+65));}
	}
	
	static int MostAppear(int[] arr) {
		boolean two = false;
		int most = 0;
		int idx = 0;
		
		for (int i=0; i<arr.length; i++) {
			if(most>arr[i]) { continue; }
			else if(most==arr[i]) { idx=i; two = true; }
			else { most = arr[i]; idx=i; two = false; }
		}
		if(two) {return -1;}
		else {return idx;}
	}
}
