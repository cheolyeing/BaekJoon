import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N3009 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st1.nextToken());
		int y1 = Integer.parseInt(st1.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int x2 = Integer.parseInt(st2.nextToken());
		int y2 = Integer.parseInt(st2.nextToken());
		
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		int x3 = Integer.parseInt(st3.nextToken());
		int y3 = Integer.parseInt(st3.nextToken());
		
		int x4 = next(x1, x2, x3);
		int y4 = next(y1, y2, y3);
		
		String output = Integer.toString(x4)+" "+Integer.toString(y4);
		System.out.println(output);
	}
	
	public static int next(int x1, int x2, int x3)
	{
		if(x1==x2)
			return x3;
		else if(x2==x3)
			return x1;
		else
			return x2;
	}
}