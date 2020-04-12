import java.io.*;
import java.util.*;

public class N6581 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		String s;
		int count = 0;
		String BR = "<br>";
		
		while((s = br.readLine())!=null) {
			StringTokenizer st = new StringTokenizer(s);
			
			while(st.hasMoreTokens()) {
				String word = st.nextToken();
				
				count += word.length();
				if(count<81) {
					//System.out.println(word);
					if(word.equals(BR)) {
						sb.append("\n"); count = 0;
					} else if (word.equals("<hr>")) {
						if(count!=4) { sb.append("\n"); }
						sb.append("--------------------------------------------------------------------------------\n"); count = 0;
					} else {
						sb.append(word+" "); count++;
					}
				} else {
					int lastIdx = 0;
					while(count<81) {
						for (int i=0; i<word.length(); i++) {
							sb.append(word.charAt(i)); lastIdx = i; count++;
						}
					}
					sb.append("\n"); count=0;
					for (int i=lastIdx; i<word.length(); i++) {
						sb.append(word.charAt(i)); count++;
					} sb.append(" "); count++;
				}
			} //System.out.println(sb);
		} System.out.println(sb);
	}
		
}
