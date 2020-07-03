import java.io.*;
import java.util.*;

public class Main {

    static HashMap<String, Node> hm = new HashMap<>();

    static class Node {
        public int value, multi;

        public Node(int value, int multi) {
            this.value = value;
            this.multi = multi;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {

        hm.put("black", new Node(0, 1));
        hm.put("brown", new Node(1, 10));
        hm.put("red", new Node(2, 100));
        hm.put("orange", new Node(3, 1000));
        hm.put("yellow", new Node(4, 10000));
        hm.put("green", new Node(5, 100000));
        hm.put("blue", new Node(6, 1000000));
        hm.put("violet", new Node(7, 10000000));
        hm.put("grey", new Node(8, 100000000));
        hm.put("white", new Node(9, 1000000000));


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String color1 = br.readLine();
        String color2 = br.readLine();
        String color3 = br.readLine();

        long answer = 0;
        answer += hm.get(color1).value * 10;
        answer += hm.get(color2).value;
        answer *= hm.get(color3).multi;
        System.out.println(answer);
    }

    static void solution() {

    }
}
