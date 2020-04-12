import java.io.*;

public class N1032 {
	
	static String answer;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		answer = br.readLine();
		
		for (int i=1; i<n; i++) { 
			String s = br.readLine().trim();
			for(int j=0; j<answer.length(); j++) {
				if(answer.charAt(j)!=s.charAt(j)) {
					answer = answer.substring(0, j)+"?"+answer.substring(j+1,answer.length());
				}
			}
		} System.out.println(answer);
	}
}
