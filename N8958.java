import java.io.*;

public class N8958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			
			int numO=0, sum=0;
			
			for (int j=0; j<s.length(); j++) {
				if(s.charAt(j)=='O') {
					numO++;
				} else {
					sum+=ans(numO); numO=0;
				}
			} sum+=ans(numO); System.out.println(sum);
		}
	}
	
	static int ans(int n) {
		return n*(n+1)/2;
	}
}