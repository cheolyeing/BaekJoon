import java.io.*;
import java.util.*;
 
 
public class N3954 {
	static int m, c, i;
	static final int mod = (int)Math.pow(2, 8);
	static int[] memory, pair;
	static char[] code, input;
	
	public static void main(String[] args) throws IOException {
    	setting();
    }
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			i = Integer.parseInt(st.nextToken());
			
			memory = new int[m];
			code = new char[c];
			input = new char[i];
			pair = new int[c];
			Arrays.fill(pair, -1);
			
			String CODE = br.readLine();
			for(int k=0; k<c; k++) code[k] = CODE.charAt(k);
			setPair();
			
			String INPUT = br.readLine();
			for(int k=0; k<i; k++) input[k] = INPUT.charAt(k);
			
			solution();
		}
	}
	
	static void solution() {
		int mp=0, cp=0, ip=0, Loop=-1;
	
		for(int ex=0; ex<50000000; ex++) {
			if(code[cp]=='+') memory[mp] = (memory[mp]+1)%mod;
			else if(code[cp]=='-') {
				memory[mp]--;
				if(memory[mp]<0) memory[mp] = mod-1;
			}
			else if(code[cp]=='<') {
				mp--;
				if(mp<0) mp=m-1;
			}
			else if(code[cp]=='>') {
				mp++;
				if(mp==m) mp=0;
			}
			else if(code[cp]=='[') {
				if(memory[mp]==0) cp = pair[cp]-1;
			}
			else if(code[cp]==']') {
				if(memory[mp]!=0) {
					if(Loop<cp) Loop = cp;
					cp = pair[cp]-1;
				}
			}
			else if(code[cp]==',') {
				if(ip==i) memory[mp] = 255;
				else memory[mp] = input[ip++];
			}
			cp++;
			if(cp==c) break;
		}
		if(cp==c) System.out.println("Terminates");
		else System.out.println("Loops "+pair[Loop]+" "+Loop);
	}
	
	static void setPair() {
		Stack<Integer> stack = new Stack<Integer>();
		int close;
		
		for(int i=0; i<c; i++) {
			if(code[i]=='[') stack.push(i);
			if(code[i]==']') {
				close = stack.pop();
				pair[i] = close;
				pair[close] = i;
			}
		}
	}
}
