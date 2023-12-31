import java.io.*;
import java.util.*;

public class cp {
    static FastReader in = new FastReader();
    static FastWriter out = new FastWriter();

    public static void main(String args[]) throws IOException {
        int t = in.nextInt();
        while (t-- > 0) {
        }
        out.close();
    }

    static int[] nextArr(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        return a;
    }

    static int dfs(ArrayList<ArrayList<Integer>> adj, int[] arr, int ver, int par) {
        int total = 0;
        for (int i : adj.get(ver)) {
            if (i != par)
                total += dfs(adj, arr, i, ver);
        }
        if (total == 0)
            return arr[ver] = 1;
        return arr[ver] = total;
    }

    static ArrayList<ArrayList<Integer>> getAdj(int n) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }

    static int[] sort(int[] a) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : a)
            list.add(i);
        Collections.sort(list);
        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }
        return a;
    }
}

class FastReader {
    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");

    String nextToken() {
        while (!st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(buf.readLine());
            } catch (IOException e) {
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(nextToken());
    }

    long nextLong() {
        return Long.parseLong(nextToken());
    }

    double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    String next() {
        try {
            return buf.readLine();
        } catch (IOException e) {
        }
        return "";
    }
}

class FastWriter {
    BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(System.out));

    void print(Object object) throws IOException {
        buf.append("" + object);
    }

    void println(Object object) throws IOException {
        print(object);
        buf.append('\n');
    }

    void close() throws IOException {
        buf.close();
    }
}