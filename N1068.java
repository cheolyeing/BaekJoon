import java.io.*;
import java.util.*;

public class N1068 {
	
	static int n;
	static int[] node;
	static ArrayList<Integer> root = new ArrayList<Integer>();
	static int delete;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		node = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			node[i] = Integer.parseInt(st.nextToken());
			if(node[i]==-1) { root.add(i); }
		}
		
		delete = Integer.parseInt(br.readLine());
		dfsDelete(delete);

		for (int i=0; i<root.size(); i++) {
			if(delete!=root.get(i)) dfsFind(root.get(i));
		}
		
		System.out.println(answer);
	}
	
	static void dfsDelete(int idx) {
		node[idx] = -2;
		
		for(int i=0; i<n; i++) {
			if(node[i]==idx) {
				dfsDelete(i);
			}
		}
	}
	
	static void dfsFind(int idx) {
		boolean plus = true;
		for (int i=0; i<n; i++) {
			if(node[i]==idx) {
				plus = false;
				dfsFind(i);
			}
		}
		if(plus) answer++;
	}
}