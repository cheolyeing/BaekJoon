import java.io.*;

public class N2231 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int n = Integer.parseInt(s);
		int length = s.length();
		
		for(int i=n-10*length; i<n; i++) {
			if(n==i+DivideSum(i)) {
				System.out.println(i);
				System.exit(0);
			}
		}
		System.out.println(0);
	}
	
	
	
	static int DivideSum (int n) {
		int result = 0;
		while(!(n==0)) {
			result += n%10;
			n /= 10;
		}
		return result;
	}

}
