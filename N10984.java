import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int t=0; t<tc; t++) {
            int num = Integer.parseInt(br.readLine());
            int sum=0;
            double point = 0;
            for(int i=0; i<num; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                double b = Double.parseDouble(st.nextToken());
                sum += a;
                point += a*b;
            }
            System.out.println(sum+" "+Math.round(point/sum*10)/10.0);
        }
    }
}
