import java.io.*;
import java.util.*;

public class N11656 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().trim();
		
		ArrayList<String> answer = new ArrayList<String>();
		
		for (int i=0; i<input.length(); i++) {
			answer.add(input.substring(i));
		}
		
		Collections.sort(answer);
		for(String s : answer) {
			System.out.println(s);
		}
	}
}