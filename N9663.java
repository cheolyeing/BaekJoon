import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9663 {
	
	static int n;
	static int[] pos;
	static int ans = 0;
	
	static void BackTracking(int que) {
		
		if(que==n) { ans++; return; }
		
		for (int i=1; i<=n; i++) {
			pos[que+1] = i;
			if(check(que+1)) { BackTracking(que+1); }
		}
		return;
	}
	
	static boolean check(int que) {
		boolean Available = true;
		for(int i=1; i<que; i++) {
			if(pos[i]==pos[que]) { Available = false; }
			if(Math.abs(i-que)==Math.abs(pos[i]-pos[que])) { Available = false; }
		}
		return Available;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		pos = new int[n+1];
		// Input
		if(n%2==0) {
			for(int i=1; i<=n/2; i++) {
				pos[1] = i;
				BackTracking(1);
			}
			System.out.println(ans*2);
		} else {
			for(int i=1; i<=(n-1)/2; i++) {
				pos[1] = i;
				BackTracking(1);
			} ans*=2; pos[1] = (n-1)/2 + 1; BackTracking(1);
			System.out.println(ans);
		} 
		/* i = 1 ~ n 까지 탐색; / 위에는 반절만 탐색 후 *2
		for (int i=1; i<=n; i++) {
			pos = new int[n][2];
			pos[0][0] = 1; pos[0][1] = i;
			dfs(1);
		}
		System.out.println(ans);*/
	}
}