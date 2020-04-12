import java.io.*;
import java.util.*;

public class N2785 {
	
	static int n;
	static ArrayList<Integer> ring = new ArrayList();
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		String[] chain = br.readLine().split(" ");
		
		for (int i=0; i<n; i++) {
			ring.add(Integer.parseInt(chain[i]));
		} Collections.sort(ring);
		
		while(true) {
			if(ring.size()<=1) break;
			
			if(ring.get(0)==1) {
				ring.remove(0);
			} else {
				ring.set(0, ring.get(0)-1);
			}
			ring.remove(ring.size()-1);
			answer++;
			
		} System.out.println(answer);
	}
}