import java.io.*;
import java.util.*;

public class N1107 {
	static String channel;
	static int numChannel;
	static int now = 0;
	static int n;
	static int push = 0;
	static boolean[] broken = new boolean[12];
	static int answer = 0;
	static int pm;
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		channel = br.readLine();
		numChannel = Integer.parseInt(channel);
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			char tmp = st.nextToken().charAt(0);
			if(tmp=='+') broken[10] = true;
			else if (tmp=='-') broken[11] = true;
			else broken[tmp-'0'] = true;
		}
	}
	
	static void solution() {
		if(numChannel==100) { System.out.println(0); System.exit(0); }
		else { pm = Math.abs(numChannel - now); }
		
	}
	
	static void dfs(int n) {
		if(n==channel.length()) { answer = n+Math.abs(push-numChannel); return; }
		
		int tmp = (int)channel.charAt(n)-'0';
		if(!broken[tmp]) {
			push = 10*push + tmp;
		} else {
			int up = tmp+1;
			int down = tmp-1;
			
		}
	}
}
