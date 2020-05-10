import java.io.*;
import java.util.*;

public class N2631_RE {
	static int n, arr[];
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
	}
	
	static void solution() {
		int[] lis = new int[n];
		int idx=0;
		lis[idx++] = arr[0];
		for(int i=1; i<n; i++) {
			if(lis[idx-1]<arr[i]) {
				lis[idx++] = arr[i];
			} else if(lis[0]>arr[i]) {
				lis[0] = arr[i];
			} else {
				int tmp = Arrays.binarySearch(lis, 0, idx, arr[i]);
				lis[tmp<0 ? -tmp-1 : tmp] = arr[i];
			}
		}
		System.out.println(n-idx);
	}
}
