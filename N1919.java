import java.io.*;
public class N1919 {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine().trim();
		String str2 = br.readLine().trim();
		
		int[] count1 = checker(str1);
		int[] count2 = checker(str2);
		
		int answer = 0;
		for (int i=0; i<26; i++) {
			answer += Math.abs(count1[i]-count2[i]);
		}
		
		System.out.println(answer);
	}
	
	static int[] checker(String str) {
		int[] result = new int[26];
		for (int i=0; i<str.length(); i++) {
			result[str.charAt(i)-97]++;
		}
		return result;
	}
}