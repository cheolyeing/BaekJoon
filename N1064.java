import java.io.*;
import java.util.*;
import java.awt.*;

public class N1064 {
	static Point p1, p2, p3;
	final static int inf = 9999999; 
	static double max=Double.MIN_VALUE, min=Double.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		p1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		p2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		p3 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	}
	
	static void solution() {
		if(find(p1, p2, p3)) {
			double len = dist(p1, p2, p3);
			max = Math.max(max, len); min = Math.min(min, len);
		}
		
		if(find(p1, p3, p2)) {
			double len = dist(p1, p3, p2);
			max = Math.max(max, len); min = Math.min(min, len);
		}
		
		if(find(p2, p1, p3)) {
			double len = dist(p2, p1, p3);
			max = Math.max(max, len); min = Math.min(min, len);
		}
		
		if(find(p2, p3, p1)) {
			double len = dist(p2, p3, p1);
			max = Math.max(max, len); min = Math.min(min, len);
		}
		
		if(find(p3, p2, p1)) {
			double len = dist(p3, p2, p1);
			max = Math.max(max, len); min = Math.min(min, len);
		}
		
		if(find(p3, p1, p2)) {
			double len = dist(p3, p1, p2);
			max = Math.max(max, len); min = Math.min(min, len);
		}
		
		if(max==Double.MIN_VALUE) System.out.println(-1);
		else System.out.println(max-min);
	}
	
	static boolean find(Point a1, Point a2, Point a3) {
		if(a1.x==a2.x && a2.x==a3.x) return false;
		if(a1.y==a2.y && a2.y==a3.y) return false;
		if((double)(a1.y-a2.y)/(double)(a1.x-a2.x)==(double)(a2.y-a3.y)/(double)(a2.x-a3.x)) return false;
		return true;
	}
	
	static double dist(Point a1, Point a2, Point a3) {
		return 2*(Math.sqrt(Math.pow(a1.x-a2.x, 2)+Math.pow(a1.y-a2.y, 2))+Math.sqrt(Math.pow(a2.x-a3.x, 2)+Math.pow(a2.y-a3.y, 2)));
	}
}
