import java.io.*;
import java.util.*;

public class N1517 {
	
	static int n;
	static long arr[], sorted[];
	static long ans = 0;
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new long[n];
		sorted = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
	}
	
	static void solution() {
		mergeSort(arr, 0, n-1);
		System.out.println(ans);
	}
	
	static void mergeSort(long[] arr, int low, int high) {
		if(low < high) {
			int mid = (low+high)/2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid+1, high);
			merge(arr, low, mid, high);
		}
	}
	 
	static void merge(long[] arr, int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		int index = low;
	 
		while(i <= mid && j <= high) {
			if(arr[i] <= arr[j])
				sorted[index++] = arr[i++];
			else {
				sorted[index++] = arr[j++];
				ans += (mid + 1 - i);
			}
		}
	 
		while(i <= mid) 
			sorted[index++] = arr[i++];	        
		while(j <= high)
			sorted[index++] = arr[j++];
		for(int k=low; k<=high; k++)
			arr[k] = sorted[k];
	}
}
