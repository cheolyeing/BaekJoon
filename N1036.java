import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static Number[] number = new Number[36];
    static String input[];

    static class Number implements Comparable<Number> {
        public char c;
        public int num;
        public int used[] = new int[54];
        public int compareArr[] = new int[54];

        public Number(char c, int num) {
            this.c = c;
            this.num = num;
        }

        public void numLifting(int Num) {
            for (int i = 0; i < 54; i++) {
                if (used[i] >= 36) {
                    int lift = used[i] / 36;
                    used[i] -= lift * 36;
                    used[i + 1] += lift;
                }
            }
            makeCompareArr(Num - num);
        }

        public void makeCompareArr(int Num) {
            for (int i = 0; i < 54; i++) compareArr[i] = used[i] * Num;
            for (int i = 0; i < 53; i++) {
                if (compareArr[i] >= 36) {
                    int lift = compareArr[i] / 36;
                    compareArr[i] -= lift * 36;
                    compareArr[i + 1] += lift;
                }
            }
        }

        @Override
        public int compareTo(Number number) {
            for (int i = 53; i >= 0; i--) {
                if (this.compareArr[i] == number.compareArr[i]) continue;
                else return this.compareArr[i] - number.compareArr[i];
            }
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        input = new String[n];
        for (int i = 0; i < n; i++) input[i] = br.readLine();

        k = Integer.parseInt(br.readLine());
    }

    static void solution() {
        makeNumber();
        for (int i = 0; i < n; i++) countAlpha(input[i]);
        numLifting();
        Arrays.sort(number);
        replaceNumber();
        addAll();
    }

    static void showAnswer(int answer[]) {
        boolean start = false;
        for (int i = 53; i >= 0; i--) {
            if (start) {
                System.out.print(IntToChar(answer[i]));
            } else {
                if (answer[i] != 0) {
                    start = true;
                    System.out.print(IntToChar(answer[i]));
                }
            }
        }
        if(!start) System.out.println(0);
    }

    static void addAll() {
        int answer[] = new int[54];

        for (int i = 0; i < 54; i++) {
            for (int j = 0; j < 36; j++) {
                answer[i] += number[j].compareArr[i];
            }
        }

        for (int i = 0; i < 54; i++) {
            if (answer[i] >= 36) {
                int lift = answer[i] / 36;
                answer[i] -= 36 * lift;
                answer[i + 1] += lift;
            }
        }
        showAnswer(answer);
    }

    static void replaceNumber() {
        for (int i = 35; i > 35 - k; i--) number[i].num = 35;

        for (int i = 0; i < 36; i++) number[i].numLifting(number[i].num * 2);

    }

    static void numLifting() {
        for (int i = 0; i < 36; i++) {
            number[i].numLifting(35);
        }
    }

    static void countAlpha(String input) {
        int digit = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            int num = CharToInt(input.charAt(i));
            number[num].used[digit++]++;
        }
    }

    static int CharToInt(char c) {
        if ((int) c < 60) return c - '0';
        else return c - 'A' + 10;
    }

    static char IntToChar(int n) {
        if (n < 10) return (char) (n + '0');
        else return (char) (n - 10 + 'A');
    }

    static void makeNumber() {
        for (int i = 0; i < 10; i++) {
            char c = (char) (i + '0');
            number[i] = new Number(c, i);
        }
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'A');
            int num = i + 10;
            number[num] = new Number(c, num);
        }
    }
}
