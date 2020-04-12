import java.io.*;

public class N6118 {
	
	static int n;
	static int m;
	static int[][] info;
	static int[] answer;
	static int count = 1;
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		info = new int[m][2];
		answer = new int[n+1];
		
		for (int i=0; i<m; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			info[i][0] = a; info[i][1] = b;
			if(a==1 && answer[b]==0) {answer[b] = 1; count++;}
			if(b==1 && answer[a]==0) {answer[a] = 1; count++;}
		}
	}
	
	static void solution () {
		
		for(int i=1; i<n; i++) {
			for(int j=2; j<=n; j++) {
				if(answer[j]==i) {
					for(int k=0; k<m; k++) {
						if(info[k][0]==1 || info[k][1]==1) {}
						else {
							if(info[k][0]==j && answer[info[k][1]]==0) {
								answer[info[k][1]] = i+1;
							} else if(info[k][1]==j && answer[info[k][0]]==0) {
								answer[info[k][0]] = i+1;
							}
						}
					}
				}
			}
		}
		
		int ans1=0, ans2=0, ans3=0;
		
		for (int i=1; i<=n; i++) {
			if(answer[i]>ans2) {
				ans2 = answer[i]; ans3 = 1; ans1 = i;
			} else if (answer[i]==ans2) ans3++;
		}
		System.out.println(ans1+" "+ans2+" "+ans3);
	}
}