import java.io.*;
import java.util.*;

public class N2012 {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		
		for(int i=1; i<=n; i++) arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		long ans = 0;
		for(int i=1; i<=n; i++) ans += Math.abs(arr[i]-i);
		System.out.println(ans);
	}
}