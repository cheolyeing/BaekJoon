import java.io.*;
import java.util.*;

public class N10952 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		
		while(!s.equals("0 0")) {
			StringTokenizer st = new StringTokenizer(s);
			
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			bw.write(a+b+"\n");
			
			s = br.readLine();
		} bw.flush();
	}
}