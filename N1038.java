import java.io.*;

public class N1038 {
	static int n;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
	}
	
	static void solution() {
		if(n<10) {
			System.out.println(n); return;
		} else {
			int cnt = 9;
			for(int i=2; i<11; i++) {
				for(int s=i-1; s<10; s++) {
					cnt += comb(s, i-1);
					if(cnt>=n) {
						find(s, i-1, comb(s,i-1)-(cnt-n));
						return;
					}
				}
			}
		}
		System.out.println(-1);
	}
	
	static void find(int start, int digit, int num) {
		System.out.print(start);
		if(digit==0) return;
		int cnt = 0;
		for(int i=digit-1; i<start; i++) {
			cnt += comb(i, digit-1);
			if(cnt>=num) {
				find(i, digit-1, comb(i, digit-1)-(cnt-num));
				return;
			}
		}
	}
	
	static int comb(int n, int r) {
		if(r>n-r) return comb(n, n-r);
		if(n<r) return 0;
		int res = 1;
		for(int i=0; i<r; i++) res *= (n-i);
		for(int i=1; i<=r; i++) res /= i;
		return res;
	}
}
