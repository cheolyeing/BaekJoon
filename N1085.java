import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class N1085 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int x = Integer.parseInt(input.split(" ")[0]);
		int y = Integer.parseInt(input.split(" ")[1]);
		int w = Integer.parseInt(input.split(" ")[2]);
		int h = Integer.parseInt(input.split(" ")[3]);
		
		System.out.print(Math.min(Math.min(x, y), Math.min(w-x, h-y)));
	}
}