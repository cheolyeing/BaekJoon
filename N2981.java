import java.io.*;
import java.util.*;

public class N2981 {
	static int n, arr[];
	static HashSet<Integer> hs = new HashSet<Integer>();
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
	}
	
	static void solution() {
		int gcd = arr[1] - arr[0];
		for(int i=2; i<n; i++) {
			gcd = GCD(gcd, arr[i]-arr[i-1]);
		}
		
		hs.add(gcd);
		for(int i=2; i*i<=gcd; i++) {
			if(gcd%i==0) {
				hs.add(i); hs.add(gcd/i);
			}
		}
		
		List<Integer> li = new ArrayList<Integer>(hs);
		Collections.sort(li);
		for(int i : li) System.out.print(i+" ");
	}
	
	static int GCD(int a, int b) {
		if(a%b==0) return b;
		return GCD(b, a%b);
	}
}
