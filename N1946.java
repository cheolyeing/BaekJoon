import java.io.*;
import java.util.*;

public class N1946 {
	static int n, arr[][];
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][2];
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			solution();
		}
	}
	
	static void solution() {
		int except = 0;
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int compare = 0;
		boolean deleted = false;
		for(int i=0; i<n-1; i++) {
			if(!deleted) compare = arr[i][1];
			if(compare<arr[i+1][1]) {
				except++; deleted = true;
			} else deleted = false;
		}
		System.out.println(n-except);
	}
}
