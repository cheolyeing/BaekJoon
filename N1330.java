import java.io.*;
import java.util.*;

public class N1330 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		if(A>B) {
			System.out.println(">");
		} else if(B>A) {
			System.out.println("<");
		} else {System.out.println("==");}
	}
}