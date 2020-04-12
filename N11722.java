import java.io.*;
import java.util.*;

public class N11722 {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		solution();
	}
	
	static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++) arr[i] = Integer.parseInt(st.nextToken());
		System.out.println(lis());
	}
	
	static int lis() {
		int idx = 1;
		int[] l = new int[n+1];
		l[1] = arr[n];
		
		for (int i=1; i<n; i++) {
			if(l[idx]<arr[n-i]) {
				l[idx+1] = arr[n-i]; idx++;
			}
			else if(l[1]>arr[n-i]) l[1] = arr[n-i];
			else {
				int tmp = Arrays.binarySearch(l, 0, idx, arr[n-i]);
				l[tmp>0 ? tmp : -tmp-1] = arr[n-i];
			}
		}
		return idx;
	}
	
	static void show(int[] arr, int idx) {
		System.out.print("<");
		for(int i=1; i<=idx; i++) System.out.print(arr[i]+" ");
		System.out.println(">");
		System.out.println("-------");
	}
}
