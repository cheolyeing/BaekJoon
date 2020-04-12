import java.io.*;
import java.util.*;

public class N2675 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TestCase = Integer.parseInt(br.readLine());
		
		for(int i=0; i<TestCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int time = Integer.parseInt(st.nextToken());
			String word = st.nextToken();
			
			for(int j=0; j<word.length(); j++) {
				for(int k=0; k<time; k++) {
					System.out.print(word.charAt(j));
				}
			} System.out.println();
		}
	}
}
