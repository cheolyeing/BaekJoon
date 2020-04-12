import java.io.*;
import java.util.*;

public class N1912 {
	
	static int n;
	static int[] nums;
	static int[] ans;
	static int answer = -1000;
	
	public static void main(String[] args) throws IOException {
		setting();
		answer = ans[0];
		for (int i=1; i<n; i++) {
			if(ans[i]<ans[i]+ans[i-1]) {
				ans[i] = ans[i]+ans[i-1];
				
			} answer = Math.max(ans[i], answer);
		}
		
		/*ArrayList<Integer> answer = new ArrayList<Integer>();
		for (int i=0; i<n; i++) {
			answer.add(ans[i]);
		}
		Collections.sort(answer);
		System.out.println(answer.get(answer.size()-1));*/
		System.out.println(answer);
	}
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = new int[n]; ans = new int[n];
		
		String[] input = br.readLine().split(" ");
		for (int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(input[i]);
			ans[i] = nums[i];
		}
	}

}
