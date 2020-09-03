import java.io.*;
import java.util.*;

public class Main {

    static final String OPS = "+-*/";
    static LinkedList<Long> number = new LinkedList<>();
    static LinkedList<Character> operator = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] parsed = input.split("[+]|-|[*]|/");
        for (String s : parsed) {
            if (s.length() == 0) continue;
            number.add(Long.parseLong(s));
        }
        for (char c : input.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/') operator.add(c);
        }

        if (input.charAt(0) == '-') {
            number.set(0, number.get(0) * -1);
            operator.remove(0);
        }
    }

    static void solution() {
        while (operator.size() > 1) {
            int front = 0, back = 0;
            char opFront = operator.get(0);
            char opBack = operator.get(operator.size() - 1);
            front = (opFront == '+' || opFront == '-') ? -1 : 1;
            back = (opBack == '+' || opBack == '-') ? -1 : 1;

            if (front > back) {
                long value = operate(number.get(0), number.get(1), opFront);
                executeFront();
                number.add(0, value);
            } else if (front < back) {
                long value = operate(number.get(number.size() - 2), number.get(number.size() - 1), opBack);
                executeBack();
                number.add(value);
            } else {
                long valFront = operate(number.get(0), number.get(1), opFront);
                long valBack = operate(number.get(number.size() - 2), number.get(number.size() - 1), opBack);
                if (valFront < valBack) {
                    executeBack();
                    number.add(valBack);
                } else {
                    executeFront();
                    number.add(0, valFront);
                }
            }
        }
        if (operator.size() == 1) {
            System.out.println(operate(number.get(0), number.get(1), operator.get(0)));
        } else {
            System.out.println(number.get(0));
        }
    }

    static long operate(long n1, long n2, char op) {
        if (op == '+') {
            return n1 + n2;
        } else if (op == '-') {
            return n1 - n2;
        } else if (op == '*') {
            return n1 * n2;
        } else {
            return n1 / n2;
        }
    }

    static void executeFront() {
        number.remove(0);
        number.remove(0);
        operator.remove(0);
    }

    static void executeBack() {
        number.remove(number.size() - 1);
        number.remove(number.size() - 1);
        operator.remove(operator.size() - 1);
    }
}
