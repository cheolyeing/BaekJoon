import java.io.*;
import java.util.*;

public class N1173 {
	static int N, m, M, T, R;
	public static void main(String[] args) throws IOException {
		setting();
		System.out.println(solution(m));
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
	}
	
	static int solution(int heart) {
		int time = 0;
		if(m+T>M) return -1;
		else {
			int training = 0;
			while(true) {
				if(training==N) break;
				
				if(heart+T<=M) {
					training++; heart += T;
				} else {
					heart = Math.max(m, heart-R);
				}
				time++;
			}
		}
			
		return time;
	}
}