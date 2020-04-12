import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2869 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		if(A==V)
		{ System.out.println(1); } 
		else if((V-A)%(A-B)==0)
		{System.out.println((V-A)/(A-B)+1);}
		else
		{System.out.println((V-A)/(A-B)+2);}
	}
}