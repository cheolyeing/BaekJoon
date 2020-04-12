import java.io.*;
import java.util.*;

public class N1181 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<String> Dic1 = new ArrayList<String>();
		ArrayList<String> Dic2 = new ArrayList<String>();
		
		for (int i=0; i<n; i++) {
			String input = br.readLine();
			if(input.length()>=10) {
				if(!Dic2.contains(input.length()+input)) { Dic2.add(input.length()+input); }
			}
			else {
				if(!Dic1.contains(input.length()+input)) { Dic1.add(input.length()+input); }
			}
		}
		Collections.sort(Dic1); Collections.sort(Dic2);
		
		for (int i=0; i<Dic1.size(); i++) { System.out.println(Dic1.get(i).substring(1)); }
		for (int i=0; i<Dic2.size(); i++) { System.out.println(Dic2.get(i).substring(2)); }
	}
}