import java.io.*;
import java.util.*;
public class N17140 {
	static int r, c, k;
	static int[][] arr = new int[3][3];
	public static void main(String[] args) throws IOException {
		setting();
		System.out.println(bfs());
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static int bfs() {
		Queue<int[][]> q = new LinkedList<int[][]>();
		q.add(arr);
		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				int[][] tmp = q.poll();
				/*System.out.println("---"+time+"---");
				showArray(tmp);*/
				if(tmp.length>r-1 && tmp[0].length>c-1 && tmp[r-1][c-1]==k) return time;
				if(tmp.length>=tmp[0].length) q.add(operR(tmp));
				else q.add(operC(tmp));
			}
			time++;
			if(time>100) break;
		}
		return -1;
	}
	
	static int[][] operR(int[][] arr) {
		int[][] res = new int[arr.length][arr[0].length*2];
		int maxR = 0;
		
		for(int i=0; i<arr.length; i++) {
			int[] cnt = new int[101];
			
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j]==0) continue;
				if(cnt[arr[i][j]]==0) cnt[arr[i][j]] = 1000 + arr[i][j];
				else cnt[arr[i][j]] += 1000;
			}
			
			Arrays.sort(cnt);
			int idx=0;
			
			for(int j=0; j<cnt.length; j++) {
				if(cnt[j]==0) continue;
				res[i][idx++] = cnt[j]%1000;
				res[i][idx++] = cnt[j]/1000;
			}
			maxR = Math.max(maxR, idx);
		}
		
		int[][] result = new int[arr.length][maxR];
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result[i].length; j++) {
				result[i][j] = res[i][j];
			}
		}
		return result;
	}
	
	static int[][] operC(int[][] arr) {
		int[][] res = new int[arr.length*2][arr[0].length];
		int maxC = 0;
		
		for(int i=0; i<arr[0].length; i++) {
			int[] cnt = new int[101];
			
			for(int j=0; j<arr.length; j++) {
				if(arr[j][i]==0) continue;
				if(cnt[arr[j][i]]==0) cnt[arr[j][i]] = 1000 + arr[j][i];
				else cnt[arr[j][i]] += 1000;
			}
			
			Arrays.sort(cnt);
			int idx=0;
			
			for(int j=0; j<cnt.length; j++) {
				if(cnt[j]==0) continue;
				res[idx++][i] = cnt[j]%1000;
				res[idx++][i] = cnt[j]/1000;
			}
			maxC = Math.max(maxC, idx);
		}
		
		int[][] result = new int[maxC][arr[0].length];
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result[i].length; j++) {
				result[i][j] = res[i][j];
			}
		}
		return result;
	}
	
	static void showArray(int[][] arr) {
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			} System.out.println();
		}
	}
}