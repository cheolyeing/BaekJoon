import java.io.*;
import java.util.*;

public class N2352 {
	
	static int n;
	static int[] conductor;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		conductor = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<n; i++) { 
			conductor[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] lis = new int[n];
		lis[0] = conductor[0];
		int idx = 1;
		int tmp = 0;
		
		for (int i=1; i<n; i++) {
			if(lis[idx-1]<conductor[i]) {
				lis[idx++] = conductor[i];
			} else if (lis[0] > conductor[i]) {
				lis[0] = conductor[i];
			} else {
				tmp = Arrays.binarySearch(lis, 0, idx, conductor[i]);
				lis[tmp<0 ? -tmp-1:tmp] = conductor[i];
			}
		} System.out.println(idx);
	}
	
	static void showArray() {
		for (int i=0; i<n; i++) {
			System.out.println(conductor[i]+" ");
		}
	}
}