import java.io.*;

public class N10845 {
	static class Queue {
		private int[] arr;
		private int front, back;
		
		public Queue() {
			this.arr = new int[10001];
			this.front = 0;
			this.back = 0;
		}
		
		void push(int x) {
			arr[back++] = x;
		}
		
		void pop() {
			System.out.println(check() ? -1 : arr[front++]);
		}
		
		void size() {
			System.out.println(back-front);
		}
		
		void empty() {
			System.out.println(check() ? 1 : 0);
		}
		
		void front() {
			System.out.println(check() ? -1 : arr[front]);
		}
		
		void back() {
			System.out.println(check() ? -1 : arr[back-1]);
		}
		
		boolean check() {
			return back-front==0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Queue q = new Queue();
		for(int i=0; i<n; i++) {
			String[] command = br.readLine().split(" ");
			if(command.length==1) {
				if(command[0].equals("pop")) q.pop();
				else if(command[0].equals("size")) q.size();
				else if(command[0].equals("empty")) q.empty();
				else if(command[0].equals("front")) q.front();
				else q.back();
			} else {
				int num = Integer.parseInt(command[1]);
				q.push(num);
			}
		}
	}
}
