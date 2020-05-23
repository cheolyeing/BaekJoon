import java.io.*;
import java.util.*;

public class N2568 {
	static int n, lis[];
	static Pair[] arr, trace;
	static boolean[] visited = new boolean[500001];
	static class Pair implements Comparable<Pair> {
		int l, r;
		public Pair(int l, int r) {
			this.l = l; this.r  = r;
		}
		@Override
		public int compareTo(Pair a) {
			return this.l - a.l;
		}
	}
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		trace = new Pair[n];
		arr = new Pair[n];
		lis = new int[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Pair(a, b);
			visited[a] = true;
		}
		
		Arrays.sort(arr);
	}
	
	static int LIS() {
		int idx = 0;
		lis[idx] = arr[0].r;
		trace[0] = new Pair(0, arr[0].l);
		
		for(int i=1; i<n; i++) {
			if(lis[idx]<arr[i].r) {
				lis[++idx] = arr[i].r;
				trace[i] = new Pair(idx, arr[i].l);
			} else if(lis[0]>arr[i].r) {
				lis[0] = arr[i].r;
				trace[i] = new Pair(0, arr[i].l);
			} else {
				int tmp = Arrays.binarySearch(lis, 0, idx, arr[i].r);
				lis[tmp<0 ? -tmp-1:tmp] = arr[i].r;
				trace[i] = new Pair(tmp<0? -tmp-1:tmp, arr[i].l);
			}
		}
		return idx;
	}
	
	static void solution() {
		int idx = LIS();
		System.out.println(n-idx-1);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=n-1; i>=0; i--) {
			if(trace[i].l==idx) {
				list.add(trace[i].r);
				idx--;
			}
		}
		
		for(int i : list) visited[i] = false;
		
		for(int i=0; i<500001; i++) if(visited[i]) System.out.println(i);
		
	}
}
