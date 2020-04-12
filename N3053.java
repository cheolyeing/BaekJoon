import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class N3053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int r = Integer.parseInt(br.readLine());
		double euclid = (double) (r*r*Math.PI);
		double taxi = 2*r*r; 
		System.out.println(Math.round(euclid*1000000)/1000000.0);	
		System.out.println(String.format("%.6f", taxi));
		}
}