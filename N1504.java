import java.util.*;
import java.io.*;
public class N1504 {
	static int n, m, min, p1, p2, bad;
	static int map[][];
	static long dis[];
	static boolean v[];
	static long INF=Integer.MAX_VALUE-1;
	public static void main(String[] args) throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String in[]=br.readLine().split(" ");
		n=Integer.parseInt(in[0]);
		m=Integer.parseInt(in[1]);
		
		map=new int[n+1][n+1];
		dis=new long[n+1];
		v=new boolean[n+1];
		
		for(int i=1;i<=n;i++)
		Arrays.fill(map[i], 99999);
		
		for(int i=0;i<m;i++) {
			in=br.readLine().split(" ");
			
			int s=Integer.parseInt(in[0]);
			int e=Integer.parseInt(in[1]);
			int w=Integer.parseInt(in[2]);
			
			if(map[s][e]>w) {
				map[s][e]=w;
				map[e][s]=w;
			}
			
		}
		in=br.readLine().split(" ");
		 p1=Integer.parseInt(in[0]);
		 p2=Integer.parseInt(in[1]);
		 
		 long a1=find(1,p1,p2,n);
		 long a2=find(1,p2,p1,n);
		
		if(a1==-1&&a2==-1) {
			System.out.println(-1);
		} else if(a1==-1){
			System.out.println(a2);
		} else if(a2==-1){
			System.out.println(a1);
		} else {
			System.out.println(Math.min(a1,a2));
		}
	}
	
	static long find(int s,int m1,int m2,int e) {
		
		long a1=dist(s,m1);
		long a2=dist(m1,m2);
		long a3=dist(m2,e);
		
		if(a1==INF||a2==INF||a3==INF) {
			return -1;
		}
		else {
			return a1+a2+a3;
		}
	}
	
	static long dist(int s,int e) {
		Arrays.fill(dis, INF);
		Arrays.fill(v, false);
			dis[s]=0;
			
			for(int i=1;i<=n;i++) {				
				long min=Integer.MAX_VALUE;
				int from=0;

				for(int j=1;j<=n;j++) {
					if(!v[j]&&dis[j]<min) {
						min=dis[j];
						from=j;
					}		
				}				
				v[from]=true;

				for(int j=1;j<=n;j++) {
					if(map[from][j]!=0&&map[from][j]!=99999) {
						if(dis[j]>dis[from]+map[from][j]) {
							dis[j]=dis[from]+map[from][j];
						}
					}	
				}	
			}
		return dis[e];	
	}
}