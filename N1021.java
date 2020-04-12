import java.io.*;
import java.util.*;

public class N1021 {
	
	static int n;
	static boolean right;
	static int adj = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int ans = 0;
		List numbers = new LinkedList<Integer>();
		for (int i=1; i<=n; i++) { numbers.add(i); }
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++) {
			int num = Integer.parseInt(st.nextToken());
			while(true) {
				if((int)numbers.get(0)==num) { n--; numbers.remove(0); break; }
				if(numbers.indexOf(num)<=numbers.size()/2) {
					numbers.add(numbers.get(0));
					numbers.remove(0);
				} else {
					numbers.add(0, numbers.get(numbers.size()-1));
					numbers.remove(numbers.size()-1);
				} ans++;
			}
		} System.out.println(ans);
	}
	
	static void showList (List a) {
		for (int i=0; i<a.size(); i++) {
			System.out.print(a.get(i)+" ");
		} System.out.println();
	}
}
