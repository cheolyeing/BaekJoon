import java.io.*;

public class N1935 {
	static int n, nums[];
	static String s;
	static Stack stack = new Stack();
	
	static class Stack {
		private double[] arr;
		private int idx;
		public Stack() {
			this.arr = new double[51];
			this.idx = 0;
		}
		
		void push(double n) {
			arr[idx++] = n;
		}
		
		double pop() {
			return arr[--idx];
		}
	}
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = br.readLine();
		nums = new int[n];
		for(int i=0; i<n; i++) nums[i] = Integer.parseInt(br.readLine());
	}
	
	static void solution() {
		for(char c : s.toCharArray()) {
			if(isNum(c)) {
				stack.push(nums[c-'A']);
			} else {
				double num2 = stack.pop();
				double num1 = stack.pop();
				double res = 0;
				
				switch(c) {
					case '+' :
						res = num1+num2;
						break;
					case '-' :
						res = num1-num2;
						break;
					case '*' :
						res = num1*num2;
						break;
					case '/' :
						res = num1/num2;
						break;
					default :
						break;
				}
				stack.push(res);
			}
		}
		System.out.println(String.format("%.2f", stack.pop()));
	}
	
	static boolean isNum(char c) {
		int ascii = c - 'A';
		if(ascii>=0 && ascii<26) return true;
		else return false;
	}
}
