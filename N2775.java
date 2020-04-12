import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2775 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TestCase = Integer.parseInt(br.readLine());
		
		for (int i=0; i<TestCase; i++)
		{
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			System.out.println(Combination((k+n), (k+1)));
		}
	}
	
	public static int Combination(int n, int r)
	{
		int result = 1;
		
		for(int i=1; i<=r; i++)
		{ result *= (n-i+1); result/=i; }
		return result;
	}
}