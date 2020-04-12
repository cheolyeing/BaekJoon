import java.io.*;
import java.util.*;

public class N1059 {
	
	static int l;
	static int[] lucky;
	static int n;
	static int small = 0;
	static int large = 1001;
	
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		l = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(br.readLine());
		br.close();
		lucky = new int[l];
		for (int i=0; i<l; i++) {
			lucky[i] = Integer.parseInt(st.nextToken());
			if(lucky[i]==n) { System.out.println(0); System.exit(0);}
			else {
				if(lucky[i]<n && small<lucky[i]) small = lucky[i];
				else if(lucky[i]>n && large>lucky[i]) large = lucky[i];
			}
		}
		int a = n-small; int b = large-n; 
		int answer = a*b-1;
		
		System.out.println(answer);
	}
}