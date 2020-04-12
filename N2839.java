import java.io.*;

public class N2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		
		if(n>12) {
			if((n-12)%5 == 0) {
				ans += (n-12)/5;
				n -= (n-12)/5 * 5;
			}
			else {
				ans += (n-12)/5 + 1;
				n  = n - ((n-12)/5+1)*5;
			}
		}
		
		if(n==3 || n==5) {ans+=1;}
		else if(n==6 || n==8 || n==10) {ans+=2;}
		else if(n==9 || n==11) { ans+=3; }
		else if(n==12) {ans+=4;}
		else {}
		
		if(n==4 || n==7) {
			System.out.println(-1);
		} else {System.out.println(ans);}
	}
}