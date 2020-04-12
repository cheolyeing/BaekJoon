import java.io.*;
import java.util.*;

public class N2666 {
	
	static int n;
	static int[] closet;
	static int m;
	static int[] use;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		setting();
		solution(0, closet, 0);
		System.out.println(answer);
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] open = br.readLine().split(" ");
		int x = Integer.parseInt(open[0]);
		int y = Integer.parseInt(open[1]);
		int[] tmp = {x, y};
		closet = tmp;
		m = Integer.parseInt(br.readLine());
		use = new int[m];
		for (int i=0; i<m; i++) {
			use[i] = Integer.parseInt(br.readLine());
		}
	}
	
	static void solution (int n, int[] open, int ans) {
		for (int i=n; i<m; i++) {
			int num = use[i];
			if(num<open[0]) {
				ans += open[0]-num;
				open[0] = num;
			} else if(num==open[0]) {
				continue;
			} else if(open[0]<num && num<open[1]) {
				int[] tmp1 = {num, open[1]};
				solution(i+1, tmp1, ans+num-open[0]);
				int[] tmp2 = {open[0], num};
				solution(i+1, tmp2, ans+open[1]-num);
				return;
			} else if(num==open[1]) {
				continue;
			} else {
				ans += num-open[1];
				open[1] = num;
			}
		} if(ans<answer) { answer = ans; }
	}
}