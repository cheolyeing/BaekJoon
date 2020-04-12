import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.StringTokenizer;

public class N1978 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int N = Integer.parseInt(br.readLine());
		int result = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
		{
			int Num = Integer.parseInt(st.nextToken());
			if(prime(Num))
			{ result++; }
		}
		
		System.out.println(result);
	}
	
	static boolean prime (int num)
	{
		boolean check = true;
		if(num==1) { return false; }
		
		for (int i=2; i<=Math.sqrt(num); i++)
		{
			if(num%i==0)
			{ check = false; break; }
			else {}
		}
		
		return check;
	}
}