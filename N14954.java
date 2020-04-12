import java.util.*;

public class N14954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		DFS(n, n, 0);
	}
	
	static void DFS(int n, int res, int time) {
		if(4==res && !(time==0)) {
			System.out.println("UNHAPPY"); return;
		} 
		if(res==1) {
			System.out.println("HAPPY"); return;
		}
		
		int tmp = 0;
		String s = Integer.toString(res);
		for(int i=0; i<s.length(); i++) {
			tmp += (s.charAt(i) - '0')*(s.charAt(i) - '0');
		}
		DFS(n, tmp, 1);
	}
}