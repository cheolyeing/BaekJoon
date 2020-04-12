import java.io.*;
import java.util.*;

public class N1544 {
	
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ArrayList<String> dic = new ArrayList<String>();
		
		for (int i=0; i<n; i++) {
			String s = br.readLine();
			String a = s;
			//System.out.println("<<<"+s+">>>");
			boolean contain = false;
			for (int j=0; j<s.length(); j++) {
				s = s.substring(1, s.length()) + s.charAt(0);
				//System.out.println(s);
				if(dic.contains(s)) { contain = true; break; }
			}
			if(!contain) {
				//System.out.println("["+s+"]");
				dic.add(s);
			}
		} System.out.println(dic.size());
		
	}
}
