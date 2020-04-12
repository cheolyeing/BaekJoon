import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.ArrayList;

public class N2581 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> primes = prime(M, N);
		
		int size = primes.size();
		
		if(size==0)
		{ System.out.println(-1); }
		else
		{
			int minimum = primes.get(0);
			int sum = 0;
			
			for (int i=0; i<size; i++)
			{ sum += primes.get(i); }
			
			System.out.println(sum);
			System.out.println(minimum);
		}
		
	}
	
	public static ArrayList<Integer> prime(int m, int n)
	{
		ArrayList<Integer> result = new ArrayList<>();
		for (int i=Math.max(2, m); i<=n; i++)
		{	result.add(i); }
		
		for (int i=2; i<Math.sqrt(n); i++)
		{
			for (int j=0; j<result.size(); j++)
			{
				if(i<=Math.sqrt(result.get(j)) && result.get(j)%i==0)
				{
					result.remove(j);
					j--;
				}
			}
		}
		return result;
	}
}