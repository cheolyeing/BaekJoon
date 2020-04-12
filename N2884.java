import java.io.*;
import java.util.*;

public class N2884 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int hh = Integer.parseInt(st.nextToken());
		int mm = Integer.parseInt(st.nextToken());
		int h, m;
		
		if(mm-45>=0) {
			h = hh; m = mm-45;
		}
		else {
			if(hh==0) {
				h = 23; m=mm+15;
			} else {
			h = hh-1; m = mm+15;
			}
		}
		System.out.println(Integer.toString(h)+" "+Integer.toString(m));
	}	
}