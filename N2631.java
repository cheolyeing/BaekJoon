import java.io.*;
import java.util.Arrays;

public class N2631 {
	
	static int n;
	static int[] num;
	
	public static void main(String[] args) throws IOException {
		setting();
		
		int[] lis = new int[n];
		lis[0] = num[0];
		int idx = 1;
		int tmp = 0;
		
		for (int i=1; i<n; i++) {
			if(lis[idx-1]<num[i]) {
				lis[idx++] = num[i];
			} else if (lis[0] > num[i]) {
				lis[0] = num[i];
			} else {
				tmp = Arrays.binarySearch(lis, 0, idx, num[i]);
				lis[tmp<0 ? -tmp-1:tmp] = num[i];
			} 
		} System.out.println(n-idx);
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		for (int i=0; i<n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
	}
}