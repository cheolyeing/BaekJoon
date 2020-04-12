import java.io.*;
import java.util.*;

public class N1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for (int i=0; i<testCase; i++) {
			int[] important = new int[10];
			int ans = 0;
			Queue<Integer> printer = new LinkedList<Integer>();
			
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			
			String doc = br.readLine();
			
			if(N==1) { System.out.println(1); continue; }
			else {
				int num = 0;
				String[] tmp = doc.split(" ");
				for(int j=0; j<N; j++) {
					int n = Integer.parseInt(tmp[j]);
					if(j==M) { printer.add(0); num=n;}
					else{printer.add(n);} important[n]++;
				}
				
				loop :
				for(int j=0; j<9; j++) {
					if(important[9-j]!=0) {
						while(important[9-j]!=0) {
							int fi = printer.poll();
							if(9-j==num) {
								if(fi==num) {ans++;}
								if(fi==0) { ans++; System.out.println(ans); break loop; }
							} else {
								if(fi==9-j) { ans++; important[fi]--;}
								else { printer.add(fi);}
							}
						}
					}
				}
			}
		}
	}
}