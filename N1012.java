import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1012 {
	
	static int[][] map;
	static boolean[][] visit;
	static int m;
	static int n;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static Queue<Integer[]> q = new LinkedList<Integer[]>();
	static int test = 0;
	
	public static void bfs(int x, int y) {
		
		while(!q.isEmpty())
		{
			Integer[] now = q.poll();
			for (int i=0; i<4; i++)
			{
				int nx = now[0]+dx[i], ny = now[1]+dy[i];
				if(next(nx, ny))
				{
					Integer[] tmp = {nx, ny};
					q.offer(tmp);
				}
			}
		}
	}
	
	public static void setting()
	{
		for (int i=0; i<n; i++)
		{
			for (int j=0; j<m; j++)
			{ visit[i][j] = false; map[i][j]=0; }
		}
	}
	
	public static boolean inrange(int x, int y)
	{
		if(x>=0 && x<n && y>=0 && y<m)
		{ return true; }
		else { return false; }
	}
	
	public static boolean next(int x, int y)
	{
		if(inrange(x, y) && map[x][y]==1 && !visit[x][y])
		{ visit[x][y] = true; return true; }
		else {return false;}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TestCase = Integer.parseInt(br.readLine());
		
		for (int i=0; i<TestCase; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			visit = new boolean[n][m];
			setting();
			int insect = 0;
			
			for (int j=0; j<B; j++)
			{
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x]=1;
			}
			
			for (int a=0; a<n; a++)
			{
				for (int b=0; b<m; b++)
				{
					if(next(a, b))
					{
						Integer[] tmp = {a, b};
						q.offer(tmp);
						insect++;
						bfs(a, b);
					}
				}
			}
			System.out.println(insect);
		}
	}
}