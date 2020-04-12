import java.io.*;
import java.util.*;
public class N17779 {
	static int n, ans=Integer.MAX_VALUE;
	static int[][] area;
	public static void main(String[] args) throws IOException {
		setting();
		for(int x=2; x<n; x++) {
			for(int y=2; y<n; y++) {
				for(int d1=1; d1<y; d1++) {
					for(int d2=1; d2<=n-y; d2++) {
						if(x+d1+d2<=n) divideArea(x,y,d1,d2);
					}
				}
			}
		}
		System.out.println(ans);
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		area = new int[n+2][n+2];
		StringTokenizer st;
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=n; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void divideArea(int x, int y, int d1, int d2) {
		int[][] div = makeDiv(x, y, d1, d2);
		int[] arr = new int[6];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				arr[div[i][j]] += area[i][j];
			}
		}
		arr[5] += arr[0]; arr[0] = 0;
		if(arr[1]==0 || arr[2]==0 || arr[3]==0 || arr[4]==0 || arr[5]==0) return;
		ans = Math.min(ans, findMin(arr));
	}
	
	static int findMin(int[] arr) {
		Arrays.sort(arr);
		return arr[5]-arr[1];
	}
	
	static void showArray(int[][] arr) {
		for(int i=1; i<arr.length-1; i++) {
			for(int j=1; j<arr[i].length-1; j++) {
				System.out.print(arr[i][j]+" ");
			} System.out.println();
		}System.out.println("-----------------------------------");
	}
	
	static int[][] makeDiv(int x, int y, int d1, int d2) {
		int[][] div = new int[n+2][n+2];
		
		for(int i=1; i<x; i++) div[i][y] = 1;
		for(int i=n; i>y+d2; i--) div[x+d2][i] = 2;
		for(int i=1; i<y-d1; i++) div[x+d1][i] = 3;
		for(int i=n; i>x+d1+d2; i--) div[i][y+d2-d1] = 4;
		
		int d = 0;
		for(int i=x; i<=x+d1; i++) {
			div[i][y-d++] = 5;			
		}
		
		d=0;
		for(int i=x; i<=x+d2; i++) {
			div[i][y+d++] = 5;
		}
		
		d=0;
		for(int i=x+d1; i<=x+d1+d2; i++) {
			div[i][y-d1+d++] = 5;
		}
		
		d=0;
		for(int i=x+d2; i<=x+d1+d2; i++) {
			div[i][y+d2-d++] = 5;
		}
		
		for(int i=1; i<x+d1; i++) {
			for(int j=1; j<=n; j++) {
				if(div[i][j]!=0) break;
				div[i][j] = 1;
			}
		}
		
		for(int i=x+d1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(div[i][j]!=0) break;
				div[i][j] = 3;
			}
		}
		
		for(int i=1; i<=x+d2; i++) {
			for(int j=n; j>=1; j--) {
				if(div[i][j]!=0) break;
				div[i][j] = 2;
			}
		}
		
		for(int i=x+d2+1; i<=n; i++) {
			for(int j=n; j>=1; j--) {
				if(div[i][j]!=0) break;
				div[i][j] = 4;
			}
		}
		return div;
	}
}
