import java.io.*;
import java.util.*;

public class N1722 {
	static int n, problem;
	static long seq;
	static long[] factorial;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static ArrayList<Integer> li = new ArrayList<Integer>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		problem = Integer.parseInt(st.nextToken());
		factorial = factorial(n);
		for(int i=1; i<=n; i++) list.add(i);
		
		if(problem==1) {
			seq = Long.parseLong(st.nextToken());
			solution1(seq);
		} else {
			for(int i=0; i<n; i++) li.add(Integer.parseInt(st.nextToken()));
			solution2(li, 1);
		}
	}
	
	static void solution1(long seq) {
		
		int len = list.size();
		if(len==0) {
			System.out.println(sb);
			return;
		}
		
		if(factorial[len-1]>=seq) {
			sb.append(list.get(0)+" ");
			list.remove(0);
		} else {
			int idx = 0;
			while(factorial[len-1]<seq) {
				seq -= factorial[len-1];
				idx++;
			}
			sb.append(list.get(idx)+" ");
			list.remove(idx);
		}
		solution1(seq);
	}
	
	static void solution2(ArrayList<Integer> li, long time) {
		
		if(li.size()==0) {
			System.out.println(time); return;
		}
		if(list.get(0)==li.get(0)) {
			list.remove(0);
			li.remove(0);
			solution2(li, time);
		} else {
			for(int i=0; i<list.size(); i++) {
				if(list.get(i)==li.get(0)) {
					int len = list.size();
					list.remove(i); li.remove(0);
					solution2(li, time+i*factorial[len-1]);
					break;
				}
			}
		}
	}
	
	static long[] factorial(int n) {
		long[] arr = new long[n+1];
		arr[0] = 1;
		for(int i=1; i<=n; i++) {
			arr[i] = arr[i-1] * i;
		}
		return arr;
	}
}