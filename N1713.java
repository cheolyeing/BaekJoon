import java.io.*;
import java.util.*;

public class N1713 {
	static int pic;
	static int stu;
	static int up = 0;
	static int[] recom;
	static int[][] info;
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pic = Integer.parseInt(br.readLine());
		stu = Integer.parseInt(br.readLine());
		recom = new int[stu+1];
		info = new int[stu+1][3]; // 0상태, 1추천, 2순서
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=stu; i++) {
			recom[i] = Integer.parseInt(st.nextToken());
			recommend(recom[i]);
			/*for (int j=1; j<=stu; j++) {
				if(info[j][0]==1) {
					System.out.print(j+" ");
				}
			} System.out.println("----------");*/
		}
		
		for (int i=1; i<=stu; i++) {
			if(info[i][0]==1) {
				System.out.print(i+" ");
			}
		}
	}
	
	static void recommend(int i) {
		info[i][1]++;
		if(info[i][0]==1) return;
		if(up<pic) {
			info[i][0] = 1;
			info[i][2] = up;
			up++;
		}
		else {
			int minRec = Integer.MAX_VALUE, Time = Integer.MAX_VALUE;
			int idx = -1;
			for (int k=1; k<=stu; k++) {
				if(info[k][0]==1) {
					if(minRec>info[k][1]) {
						minRec = info[k][1];
						Time = info[k][2];
						idx = k;
					} else if(minRec==info[k][1] && Time>info[k][2]) {
						minRec = info[k][1];
						Time = info[k][2];
						idx = k;
					}
				}
			}
			info[idx][0] = 0;
			info[idx][1] = 0;
			info[idx][2] = 0;
			info[i][0] = 1;
			info[i][2] = up;
			up++;
		}
	}
}