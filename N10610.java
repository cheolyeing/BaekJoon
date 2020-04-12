import java.io.*;
import java.util.Arrays;

public class N10610 {
	
	static boolean has10 = false;
	static boolean times3 = false;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		nums = new int[s.length()];
		int sum = 0;
		for (int i=0; i<s.length(); i++) {
			int n = (int)s.charAt(i)-'0';
			if(n==0) {has10 = true;}
			nums[i] = n;
			sum += n;
		}
		if(sum%3==0) { times3 = true; }
		Arrays.sort(nums);
		if(has10 && times3) {
			for(int i=0; i<s.length(); i++) {
				System.out.print(nums[s.length()-i-1]);
			}
		} else { System.out.println(-1); }		
	}
}