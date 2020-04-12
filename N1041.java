import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class N1041 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] num;
    
    
    static int findMin(int n, int a, int b, int c) {
    	if(n == 2) {
    		if(a >= b && a >= c) return b + c;
    		else if(b >= a && b >= c) return a + c;
    		else return a + b;
    	}
    	else if(n == 1) {
    		if(a <= b && a <= c) return a;
    		else if(b <= a && b <= c) return b;
    		else return c;
    	}
    	return 0;
    }
    
	public static void main(String[] args) throws Exception {
		long n = Integer.parseInt(in.readLine());
		num = new int[6];
				
		String[] input = in.readLine().split(" ");
		for(int i = 0; i < 6; i++) {
			num[i] = Integer.parseInt(input[i]);
		}

		if(n == 1) {
			int max = 0;
			int sum = 0;
			for(int i = 0; i < 6; i++) {
				if(max < num[i]) max = num[i];
				sum += num[i];
			}
			
			out.write(String.valueOf(sum - max));
			out.newLine();
			out.flush();
			return;
		}
		
		int mina = (num[0] < num[5]) ? num[0] : num[5];
		int minb = (num[1] < num[4]) ? num[1] : num[4];
		int minc = (num[2] < num[3]) ? num[2] : num[3];
		
		long minthree = mina + minb + minc;
		long mintwo = findMin(2, mina, minb, minc);
		long minone = findMin(1, mina, minb, minc);
		
		long sum = ((n-2)*(n-2) + 4*(n-2)*(n-1))*minone + (8*(n-2) + 4)*mintwo + 4 * minthree;
		

		out.write(String.valueOf(sum));
		out.newLine();
		out.flush();
		return;
		
	}
}
