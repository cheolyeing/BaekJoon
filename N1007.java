import java.io.*;
import java.util.*;
import java.awt.*;

public class N1007 {
	static int n;
	static Point[] dot;
	static double ans;
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t=0; t<tc; t++) {
			ans = Double.MAX_VALUE;
			n = Integer.parseInt(br.readLine());
			dot = new Point[n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				dot[i] = new Point(x, y);
			}
			backTracking(new boolean[n], 1, 1);
			System.out.println(ans);
		}
		
	}
	
	static void calculate(boolean[] add) {
		int x=0, y=0;
		for(int i=0; i<n; i++) {
			if(add[i]) {
				x += dot[i].x; y += dot[i].y;
			} else {
				x -= dot[i].x; y -= dot[i].y;
			}
		}
		ans = Math.min(ans, value(x, y));
	}
	
	static void backTracking(boolean[] add, int last, int num) {
		if(num==n/2) {
			add[0] = true;
			calculate(add);
			return;
		}
		for(int i=last; i<n; i++) {
			add[i] = true;
			backTracking(add, i+1, num+1);
			add[i] = false;
		}
	}
	
	static double value(long x, long y) {
		return Math.sqrt(x*x+y*y);
	}
}
