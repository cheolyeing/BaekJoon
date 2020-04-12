import java.io.*;
import java.util.*;
public class N2751 {
	
	static int[] arr;
	static int n;
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for (int i=0; i<n; i++) { arr[i] = Integer.parseInt(br.readLine()); }
		quickSort(arr, 0, n-1);
		for (int i=0; i<n; i++) {
			System.out.println(arr[i]);
		}
	}
	
	static void quickSort(int[] data, int l, int r) {
		int pivot = data[(l+r)/2];
		int left = l; int right = r;
		do {
			while(data[left]<pivot) left++;
			while(data[right]>pivot) right--;
			if(left<=right) {
				int tmp = data[left];
				data[left] = data[right];
				data[right] = tmp;
				left++;
				right--;
			}
		} while(left<=right);
		if(l<right) quickSort(data, l, right);
		if(r>left) quickSort(data, left, r);
	}
}