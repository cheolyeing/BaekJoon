import java.io.*;

public class N14888 {
	
	static int n;
	static int[] nums;
	static int[] operator = new int[4]; // +, -, x, /
	static int max_ans=-1000000000;
	static int min_ans=1000000000;
	
	static void BackTracking(int pl, int mi, int mu, int di, int sum, int tmp, int oper) {
		
		if(oper==1) { tmp += nums[sum]; }
		else if(oper==2) { tmp -= nums[sum]; }
		else if(oper==3) { tmp *= nums[sum]; }
		else { tmp /= nums[sum]; }
		
		if (sum == n-1) {
			max_ans = Math.max(max_ans, tmp);
			min_ans = Math.min(min_ans, tmp);
			return;
		}
		
		if (pl<operator[0]) {BackTracking(pl+1, mi, mu, di, sum+1, tmp, 1);}
		if (mi<operator[1]) {BackTracking(pl, mi+1, mu, di, sum+1, tmp, 2);}
		if (mu<operator[2]) {BackTracking(pl, mi, mu+1, di, sum+1, tmp, 3);}
		if (di<operator[3]) {BackTracking(pl, mi, mu, di+1, sum+1, tmp, 4);}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		String[] input = br.readLine().split(" ");
		for (int i=0; i<n; i++) { nums[i] = Integer.parseInt(input[i]); }
		input = br.readLine().split(" ");
		for (int i=0; i<4; i++) { operator[i] = Integer.parseInt(input[i]); }
		if (0<operator[0]) {BackTracking(1, 0, 0, 0, 1, nums[0], 1);}
		if (0<operator[1]) {BackTracking(0, 1, 0, 0, 1, nums[0], 2);}
		if (0<operator[2]) {BackTracking(0, 0, 1, 0, 1, nums[0], 3);}
		if (0<operator[3]) {BackTracking(0, 0, 0, 1, 1, nums[0], 4);}
		System.out.println(max_ans+"\n"+min_ans);
	}
}