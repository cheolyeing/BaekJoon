import java.io.*;
import java.util.*;

public class N15953 {
	static int[][] award = {
			{0, 5000000, 3000000, 2000000, 500000, 300000, 100000},
			{0, 5120000, 2560000, 1280000, 640000, 320000, 0}
	};
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int i=1; i<=tc; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int rankA=0, rankB=0;
			
			if(a!=0) {
				for(int r=1; r<7; r++) {
					a -= r;
					if(a<=0) {
						rankA = r;
						break;
					}
				}
			}
			if(b!=0) {
				for(int r=1; r<6; r++) {
					b -= Math.pow(2, r-1);
					if(b<=0) {
						rankB = r;
						break;
					}
				}
			}
			System.out.println(award[0][rankA]+award[1][rankB]);
		}
	}
}
