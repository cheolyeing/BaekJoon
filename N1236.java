import java.io.*;
import java.util.*;
public class N1236 {
	/*static int n, m;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				map[i][j] = input[j]=='.' ? 0 : 1;
			}
		}
		int needRow=0, needCol=0;
		for(int i=0; i<n; i++) {
			int sum=0;
			for(int j=0; j<m; j++) {
				sum+=map[i][j];
			}
			if(sum==0) needRow++;
		}
		for(int i=0; i<m; i++) {
			int sum=0;
			for(int j=0; j<n; j++) {
				sum+=map[j][i];
			}
			if(sum==0) needCol++;
		}
		System.out.println(Math.max(needRow, needCol));
	}*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int k=scan.nextInt();
		
		int map[][]=new int[101][2];
		
		int min=999999;
		
		for(int i=1;i<=k;i++) {
			int temp=scan.nextInt();
			
			if(n!=0) {
				if(map[temp][0]>0) {
					map[temp][0]++;
				}else {
					map[temp][0]++;map[temp][1]=i;n--;
				}
			}
			else if(map[temp][0]>0) {
				map[temp][0]++;
			}
			else{
				min=99999;
				for(int j=1;j<101;j++) {
					if(min>map[j][0]&&map[j][0]!=0)min=map[j][0];
				}
				
				ArrayList a=new ArrayList();
				for(int j=0;j<101;j++) {
					if(map[j][0]==min)a.add(j);
				}
				int m=99999;
				for(int j=0;j<a.size();j++) {
					int t=(int)a.get(j);
					if(m>map[t][1]) {
						m=map[t][1];min=t;
					}
				}
				map[min][0]=0;map[min][1]=0;
				
				map[temp][0]=1;map[temp][1]=i;
				
			}
			
		}
		
		for(int i=1;i<101;i++) {
			if(map[i][0]!=0)System.out.printf("%d ", i);
		}
	}
}