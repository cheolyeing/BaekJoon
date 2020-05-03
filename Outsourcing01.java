import java.util.*;

public class Outsourcing01 {
	static long n, k, prime1, prime2;
	static double minSec=100000000, maxSec=0, totSec, curSec;
	public static void main(String[] args) {
		input();
		long beforeTime = System.currentTimeMillis();
		for(int i=1; i<=100; i++) {
			test(i);
		}
		long afterTime = System.currentTimeMillis();
		totSec = (afterTime - beforeTime);
		
		System.out.println("min Time : " + minSec+"ms");
		System.out.println("max Time : " + maxSec+"ms");
		System.out.println("total Time : "+ totSec+"ms");
	}
	
	public static void test(int i) {
		selectK();
		System.out.println("Test[" + i + "]");
		System.out.println("k : " + k);
		System.out.println("x : " + findX());
		System.out.println("Time : "+curSec+"ms");
		System.out.println();
	}
	
	public static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i==0) {
				prime1 = i;
				prime2 = n/prime1;
				break;
			}
		}
	}
	
	public static void selectK() {
		k = (int)(Math.random()*1000000000);
		while(k%prime1==0) k /= prime1;
		while(k%prime2==0) k /= prime2;
		if(k<=1) selectK();
	}
	
	public static int findX() {
		long beforeTime = System.currentTimeMillis();
		int x = 1;
		long rest = k%n;
		while(true) {
			if(rest==1) break;
			rest = (rest * k) % n;
			x++;
			/*if(System.currentTimeMillis()-time>1) {
				System.out.println("Can't find");
				return 0;
			}*/
		}
		long afterTime = System.currentTimeMillis();
		curSec = (afterTime - beforeTime);
		maxSec = Math.max(curSec, maxSec);
		minSec = Math.min(curSec, minSec);
		return x;
	}
}
