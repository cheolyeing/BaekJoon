import java.io.*;
import java.util.*;

public class Main {

    static int info[][] = new int[6][2];
    static int k = 0, idxW = 0, idxH = 0;
    static int bigW = 0, bigH = 0, smallW = 0, smallH = 0;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dire = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            info[i][0] = dire;
            info[i][1] = dist;
            if (dire == 1 || dire == 2) {
                if (dist > bigW) {
                    bigW = dist;
                    idxW = i;
                }
            } else {
                if (dist > bigH) {
                    bigH = dist;
                    idxH = i;
                }
            }
        }
    }

    static void solution() {
        if (idxW == idxH + 1) {
            if (idxW + 2 < 6) {
                smallW = info[idxW + 2][1];
            } else {
                smallW = info[idxW - 4][1];
            }
            if (idxH - 2 >= 0) {
                smallH = info[idxH - 2][1];
            } else {
                smallH = info[idxH + 4][1];
            }
        } else if (idxH == idxW + 1) {
            if (idxH + 2 < 6) {
                smallH = info[idxH + 2][1];
            } else {
                smallH = info[idxH - 4][1];
            }
            if (idxW - 2 >= 0) {
                smallW = info[idxW - 2][1];
            } else {
                smallW = info[idxW + 4][1];
            }
        } else {
            if (idxW > idxH) {
                smallW = info[idxW - 2][1];
                smallH = info[idxH + 2][1];
            } else {
                smallW = info[idxW + 2][1];
                smallH = info[idxH - 2][1];
            }
        }
        int area = bigW * bigH - smallW * smallH;
        //System.out.println(bigW + " " + bigH + " " + smallW + " " + smallH);
        System.out.println(area * k);
    }
}
