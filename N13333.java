import java.io.*;
import java.util.*;

public class N13333 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		for (int i=0; i<=n; i++) {
			int over = 0; int under = 0; int same = 0;
			for (int j=0; j<n; j++) {
				if(arr[j]>i) over++;
				else if(arr[j]<i) under++;
				else same++;
			}
			if(over+same>=i && (over+same-i)<=same) {
				System.out.println(i); System.exit(0);
			}
		}
	}
}