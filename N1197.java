import java.io.*;
import java.util.*;

public class N1197 {

    static int V, E;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    static class Node {
        public int V;
        public int W;
        public Node(int V, int W) {
            this.V = V; this.W = W;
        }
    }

    static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for(int i=0; i<=V; i++) graph.add(new ArrayList<Node>());
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(v1).add(new Node(v2, w));
            graph.get(v2).add(new Node(v1, w));
        }
    }

    static void solution() {

    }
}
