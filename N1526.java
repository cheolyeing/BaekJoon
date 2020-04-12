import java.io.*;
import java.util.*;

public class N1526 {
	
	static ArrayList<Integer> gold = new ArrayList<Integer>();
	static int n;
	static int length;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		length = Integer.toString(n).length();
		dfs("");
		String tmp = "";
		for (int i=1; i<length; i++) { tmp = tmp + "7"; }
		if(tmp.equals("")) {
			gold.add(4); gold.add(7);
		} else {
			gold.add(Integer.parseInt(tmp));
		}
		Collections.sort(gold);
		int ans = 0;
		
		for (int i=0; i<gold.size(); i++) {
			if(gold.get(i)>n) {
				System.out.println(ans); System.exit(0);
			} ans = gold.get(i);
		} System.out.println(ans);
	}
	
	static void dfs(String s) {
		if(s.length()==length) {
			gold.add(Integer.parseInt(s));
			//System.out.println(s);
			return;
		}
		dfs(s+"7");
		dfs(s+"4");
	}
}
