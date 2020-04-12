import java.io.*;
import java.util.*;
public class N1965 {
	
	static int n;
	static int[] sub;
	static int[] lis;
	
	public static void main(String[] args) throws IOException {
		setting();
		System.out.println(LIS());
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sub = new int[n]; lis = new int[n];
		
		String[] num = br.readLine().split(" ");
		
		for (int i=0; i<n; i++) {
			sub[i] = Integer.parseInt(num[i]);
		} lis[0] = sub[0];
	}
	
	static int LIS() {
		int idx = 1;
		int tmp = 0;
		
		for (int i=1; i<n; i++) {
			if(lis[idx-1]<sub[i]) {
				lis[idx++] = sub[i];
			} else if(lis[0]>sub[i]) {
				lis[0] = sub[i];
			} else {
				tmp = Arrays.binarySearch(lis, 0, idx, sub[i]);
				lis[tmp<0 ? -tmp-1:tmp] = sub[i];
			}
		}
		return idx;
	}
}