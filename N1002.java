import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class N1002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TestCase = Integer.parseInt(br.readLine());
		
		for(int i=0; i<TestCase; i++) {
			String input = br.readLine();
			int x1 = Integer.parseInt(input.split(" ")[0]);
			int y1 = Integer.parseInt(input.split(" ")[1]);
			int r1 = Integer.parseInt(input.split(" ")[2]);
			int x2 = Integer.parseInt(input.split(" ")[3]);
			int y2 = Integer.parseInt(input.split(" ")[4]);
			int r2 = Integer.parseInt(input.split(" ")[5]);
			
			System.out.println(answer(x1, y1, r1, x2, y2, r2));
		}
	}
	
	public static int answer(int x1, int y1, int r1, int x2, int y2, int r2) 
	{
		int start_x = Math.min(x1-r1, x2-r2);
		int finish_x = Math.max(x1+r1, x2+r2);
		int start_y = Math.min(y1-r1, y2-r2);
		int finish_y = Math.max(y1+r1, y2+r2);
		int answer = 0;
		
		int distance = (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
		int sum = (r1+r2)*(r1+r2);
		int dif = (r1-r2)*(r1-r2);
		
		if(x1==x2 && y1==y2) 
		{
			if(r1==r2)
			{ return -1; }
			else
			{ return 0; }
		}
		else if(dif==distance || sum==distance)
		{ return 1; }
		else if(dif>distance)
		{ return 0; }
		else if(sum>distance)
		{ return 2; }
		else
		{ return 0; }
	}
}