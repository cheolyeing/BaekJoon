import java.io.*;
import java.util.*;

public class N2002 {
	static int n;
	static ArrayList<String> inT = new ArrayList<String>();
	static HashMap<String, Integer> hm = new HashMap<String, Integer>();
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for(int i=1; i<=n; i++) {
			inT.add(br.readLine());
		}
		for(int i=1; i<=n; i++) {
			hm.put(br.readLine(), i);
		}
	}
	
	static void solution() {
		int nowIDX = 0;
		int good = 0;
		for(int i=0; i<inT.size(); i++) {
			if(hm.get(inT.get(i))>=nowIDX) {
				nowIDX = hm.get(inT.get(i));
				good++;
			}
		}
		System.out.println(n-good);
	}
}
