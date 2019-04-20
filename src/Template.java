import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Template {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("template.in"));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // can use something like this with trivial problems
        br.lines().forEach(System.out::println);


    }

    // not actually useful, just a sample bfs
    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.remove();

            if (current == 10)
                return current;

            queue.add(current + 1);
            queue.add(current + 2);
        }
        return 0;
    }

    // not useful, just a sample
    public static int dfs(int current) {
        if (current == 10)
            return current;

        return Math.max(dfs(current + 1), dfs(current + 2));
    }
}
