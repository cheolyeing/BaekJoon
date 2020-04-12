import java.io.*;
import java.util.*;

public class N1057 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int kim = Integer.parseInt(s[1]);
		int lim = Integer.parseInt(s[2]);
		int round = 0;
		
		ArrayList<Integer> tournament = new ArrayList<Integer>();

		for(int i=1; i<=n; i++) { tournament.add(i); }
		
		boolean go = true;
		
		while(go) {
			int length = tournament.size()/2;
			for(int i=0; i<length; i++) {
				int tmp = tournament.get(i);
				if(tmp!=kim && tmp!=lim) { tournament.remove(i); }
				else {
					tmp = tournament.get(i+1);
					if(tmp!=kim && tmp!=lim) { tournament.remove(i+1); }
					else { go=false; break;}
				}
			} round++;
		} System.out.println(round);
	}
}