import java.io.*;
import java.util.Arrays;

public class N11053 {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		setting();
		System.out.println(LIS());
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		String[] num = br.readLine().split(" ");
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(num[i]);
		}
	}
	
	static int LIS() {
		int idx = 1;
		int tmp;
		int[] lis = new int[n]; lis[0] = arr[0];
		
		for (int i=1; i<n; i++) {
			if(lis[idx-1]<arr[i]) {
				lis[idx++] = arr[i];
			} else if(lis[0]>arr[i]) {
				lis[0] = arr[i];
			} else {
				tmp = Arrays.binarySearch(lis, 0, idx, arr[i]);
				lis[tmp<0 ? -tmp-1 : tmp] = arr[i];
			}
		}
		return idx;
	}
}