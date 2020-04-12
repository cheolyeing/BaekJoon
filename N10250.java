import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N10250 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TestCase = Integer.parseInt(br.readLine());
		for(int i=0; i<TestCase; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int floor, num;
			floor = N%H;
			num = N/H+1;
			if(floor==0) {floor=H; num--;}
			
			System.out.println(Integer.toString(floor)+String.format("%02d", num));
		}
	}
}