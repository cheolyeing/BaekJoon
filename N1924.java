import java.util.*;

public class N1924 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();

		int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int date = -1;
		
		for(int i=1; i<x; i++) {
			date += day[i];
		}
		date += y;
		
		String[] ans = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
		System.out.println(ans[date%7]);
	}
}