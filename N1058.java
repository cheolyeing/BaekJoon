import java.io.*;

public class N1058 {
	
	static int[] popular;
	static boolean[][] friend;
	static int n;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		setting();
		findFriend();
		System.out.println(answer);		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		friend = new boolean[n][n];
		popular = new int[n];
		
		for (int i=0; i<n; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j=0; j<n; j++) {
				if(c[j]=='Y') {
					friend[i][j] = true;
				}
			}
		}
	}
	
	static void findFriend() {
		
		for (int i=0; i<n; i++) {
			boolean[] tmp = new boolean[n];
			
			for (int j=0; j<n; j++) {
				if(friend[i][j]) {
					tmp[j] = true;
					for (int k=0; k<n; k++) {
						if(friend[j][k] && i!=k) {
							tmp[k] = true;
						}
					}
				}
			}
			
			
			for (int j=0; j<n; j++) {
				if(tmp[j]) popular[i]++;
			}
			if(answer<popular[i]) answer = popular[i];
		}
	}
}
