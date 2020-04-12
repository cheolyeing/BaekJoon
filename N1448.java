import java.io.*;
import java.util.Arrays;

public class N1448 {
	static int n, ans=-1;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		input();
		backTracking(new int[3]);
	}
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		for (int i=1; i<=n; i++) arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
	}
	static void backTracking(int[] li) {
		for(int i=n; i>2; i--) {
			li[2] = arr[i]; li[1] = arr[i-1]; li[0] = arr[i-2];
			makeTriangle(li);
		}
		System.out.println(-1);
	}
	static void makeTriangle(int[] li) {
		int sum = li[0]+li[1]+li[2];
		int large = Math.max(li[0], Math.max(li[1], li[2]));
		
		if(sum<=ans) return;
		
		if(2*large<sum && sum>ans) {
			System.out.println(sum); System.exit(0);
		}
	}
}