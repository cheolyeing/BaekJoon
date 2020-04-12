import java.io.*;
import java.util.*;

public class N3006 {
    static int N, tree[], start;
    static item input[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        input = new item[N];
        for (start = 1; start < N; start *= 2) ;
        tree = new int[start * 2];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());
            input[i] = new item(i, num);
            update(i, 1);
        }
        Arrays.sort(input, new Comparator<item>() {
            @Override
            public int compare(item o1, item o2) {
                return o1.val - o2.val;
            }
        });
        int first = 0, end = N - 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num;
            int current, val;
            if (i % 2 == 0) {
                current = input[first].idx;
                val = input[first].val;
                num = getcnt(0, current - 1, 1, 0, start - 1);
                first++;
            } else {
                current = input[end].idx;
                val = input[end].val;
                num = getcnt(current + 1, N-1, 1, 0, start - 1);
                end--;
            }
            update(current, 0);

            sb.append(num + "\n");
        }
        System.out.println(sb);


    }

    public static void update(int idx, int val) {
        int index = start + idx;
        tree[index] = val;
        while (index > 1) {
            index /= 2;
            tree[index] = tree[index * 2] + tree[index * 2 + 1];
        }
    }

    public static int getcnt(int L, int R, int idx, int temp_L, int temp_R) {
        if (temp_L > R || temp_R < L) return 0;
        if (L <= temp_L && temp_R <= R) return tree[idx];
        int mid = (temp_L + temp_R) / 2;
        return getcnt(L, R, idx * 2, temp_L, mid) + getcnt(L, R, idx * 2 + 1, mid + 1, temp_R);


    }

    public static class item {
        int idx, val;

        public item(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}