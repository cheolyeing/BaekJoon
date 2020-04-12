import java.io.*;

public class N1748 {
	static int n;
	static long ans=0;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
	}
	
	static void solution() {
		int num=1;
		while(n>=Math.pow(10, num)-1) {
			ans += num*9*Math.pow(10, num-1);
			num++;
		}
		ans += (n-Math.pow(10, num-1)+1) * num;
		System.out.println(ans);
	}
}
