import java.io.*;

public class N2490 {
	static String[] ans = {"E", "A", "B", "C", "D"};
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i=0; i<3; i++) {
			String[] input = br.readLine().split(" ");
			int st = 0;
			for (int j=0; j<4; j++) {
				if(Integer.parseInt(input[j])==0)
					st++;
			}
			System.out.println(ans[st%5]);
		}
	}
}