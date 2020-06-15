import java.io.*;
import java.util.*;

public class N1920 {
	static int n, m;
	static int nums[], find[];
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) nums[i] = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		find = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) find[i] = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		Arrays.sort(nums);
		for(int i=0; i<m; i++) {
			System.out.println(binarySearch(find[i]) ? 1:0);
		}
	}
	
	static boolean binarySearch(int num) {
		int left = 0;
		int right = n-1;
		
		while(left<=right) {
			int mid = (left+right)/2;
			if(num<nums[mid]) right = mid-1;
			else if(num>nums[mid]) left = mid+1;
			else return true;
		}
		
		return false;
	}
}
