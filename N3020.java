import java.util.*; 
import java.io.*; 
 
public class N3020 { 
	 static int n, h, ans=0, min=Integer.MAX_VALUE;
	 static int[] bot, top, botSum, topSum, res;
	 
	public static void main(String args[]) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		bot = new int[h+1];
		top = new int[h+1];
		botSum = new int[h+2];
		topSum = new int[h+2];
		res = new int[h+1];
		
		for(int i=0; i<n/2; i++) {
			bot[Integer.parseInt(br.readLine())]++;
			top[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i=h; i>0; i--) {
			botSum[i] = botSum[i+1] + bot[i];
			topSum[i] = topSum[i+1] + top[i];
		}
		
		for(int i=1; i<=h; i++) {
			int num = botSum[i] + topSum[h-i+1];
			if(min>num) {
				min = num; ans=1;
			} else if(min==num) ans++;
		}
		
		System.out.println(min+" "+ans);
	} 
}