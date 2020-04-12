import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		while(!s.equals("0 0 0"))
		{
			StringTokenizer st = new StringTokenizer(s);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(Pita(a,b,c)) {System.out.println("right");}
			else {System.out.println("wrong");}
			s = br.readLine();
		}		
	}
	public static boolean Pita(int a, int b, int c) {
		if(a>=b && a>=c)
		{
			if(a*a==b*b+c*c)
				return true;
			else
				return false;
		}
		else if(b>=a && b>=c)
		{
			if(b*b==a*a+c*c)
				return true;
			else
				return false;
		}
		else
		{
			if(c*c==a*a+b*b)
				return true;
			else
				return false;
		}
	}
}