import java.io.*;
import java.util.*;
import java.awt.*;

public class N15686 {
	static int n, m, numOfHome=0, numOfChicken=0, ans=Integer.MAX_VALUE;
	static int[][] city, info;
	static ArrayList<Point> home = new ArrayList<Point>();
	static ArrayList<Point> chicken = new ArrayList<Point>();
	
	public static void main(String[] args) throws IOException {
		input();
		solution();
		//showInfo();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		city = new int[n+1][n+1];
		home.add(new Point(0, 0)); chicken.add(new Point(0, 0));
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=n; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if(city[i][j]==1) {
					numOfHome++; home.add(new Point(i, j));
				}
				else if(city[i][j]==2) {
					numOfChicken++; chicken.add(new Point(i, j));
				}
			}
		}
	}
	
	static void solution() {
		info = new int[numOfHome+1][numOfChicken+1];
		for (int i=1; i<=numOfHome; i++) {
			for (int j=1; j<=numOfChicken; j++) {
				info[i][j] = distance(home.get(i), chicken.get(j));
			}
		}
		int[] arr = new int[m];
		backTracking(arr, 0, 0);
		System.out.println(ans);
	}
	
	static int distance(Point a, Point b) {
		return Math.abs(a.x-b.x)+Math.abs(a.y-b.y);
	}
	
	static void backTracking(int[] arr, int num, int idx) {
		if(idx==m) {
			ans = Math.min(ans, cityDistance(arr));
			return;
		}
		
		for (int i=num+1; i<=numOfChicken; i++) {
			arr[idx] = i;
			backTracking(arr, i, idx+1);
		}
	}
	
	static int cityDistance(int[] arr) {
		int sum = 0;
		
		for (int i=1; i<=numOfHome; i++) {
			int dist = Integer.MAX_VALUE;
			for (int j=0; j<m; j++) {
				dist = Math.min(dist, info[i][arr[j]]);
			}
			sum+=dist;
		}
		return sum;
	}
	
	static void showInfo() {
		for (int i=0; i<info.length; i++) {
			for (int j=0; j<info[i].length; j++) {
				System.out.print(info[i][j]+" ");
			}
			System.out.println();
		}
	}
}