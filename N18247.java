import java.io.*;
import java.util.*;

public class N18247 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for (int i=0; i<tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n<12 || m<4) System.out.println(-1);
			else System.out.println(11*m+4);
		}
	}
}