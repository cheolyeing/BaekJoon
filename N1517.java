import java.io.*;
import java.util.*;

public class N1517 {
	static int n, ans=0;
	static int[] arr, sortedArr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		sortedArr = new int[n];
		visited = new boolean[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sortedArr[i] = arr[i];
		}
		Arrays.sort(sortedArr);
		
		for(int i=0; i<n; i++) {
			
		}
	}
}