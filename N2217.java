import java.io.*;
import java.util.*;

public class N2217 {
	
	static ArrayList<Integer> rope = new ArrayList<Integer>();
	static int ans = 0;
	static int[] ropes;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ropes = new int[n];
		
		for (int i=0; i<n; i++) {
			ropes[i] = Integer.parseInt(br.readLine());
			//rope.add(Integer.parseInt(br.readLine())); 
		}
		Arrays.sort(ropes);
		//Collections.sort(rope);
		
		for (int i=0; i<n; i++) {
			ans = Math.max(ans, ropes[i]*(n-i));
		}
		
		System.out.println(ans);
	}
}