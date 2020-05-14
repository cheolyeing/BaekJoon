import java.io.*;
import java.util.*;

public class N2108 {
	static int n, range, fv;
	static double avg, mv;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	}
	
	static void solution() {
		Arrays.sort(arr);
		range = arr[n-1] - arr[0];
		if(n%2==0) mv = (arr[n/2-1]+arr[n/2])/(double)2;
		else mv = arr[n/2]; 
		for(int i=0; i<n; i++) avg += arr[i];
		avg /= (double)n;
		
		int i=0;
		int max=0;
		int cnt=1;
		boolean first=false;
		while(i<n) {
			if(i+1==n) {
				cnt = 1;
				if(cnt==max) {
					if(first) {
						first = false;
						fv = arr[i];
					}
				}
				if(cnt>max) {
					max = cnt;
					fv = arr[i];
					first = true;
				}
				i++;
				continue;
			}
			if(arr[i]==arr[i+1]) {
				cnt++;
				if(cnt==max) {
					if(first) {
						first = false;
						fv = arr[i];
					}
				}
				if(cnt>max) {
					max = cnt;
					fv = arr[i];
					first = true;
				}
			} else {
				cnt=1;
				if(cnt==max) {
					if(first) {
						first = false;
						fv = arr[i];
					}
				}
				if(cnt>max) {
					max = cnt;
					fv = arr[i];
					first = true;
				}
			}
			i++;
		}
		
		System.out.println(String.format("%.0f", avg));
		System.out.println(String.format((mv%1==0) ? "%.0f":"%.1f", mv));
		System.out.println(String.format("%d", fv));
		System.out.println(String.format("%d", range));
	}
}
