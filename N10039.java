import java.util.*;

public class N10039 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] score = new int[5];
		int sum = 0;
		for (int i=0; i<5; i++) {
			score[i] = sc.nextInt();
			score[i] = score[i]>40? score[i]:40;
			sum+=score[i];
		}
		System.out.println(sum/5);
	}
}