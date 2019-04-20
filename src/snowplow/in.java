package snowplow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class in {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/mnt/Judge/snowplow.in"));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int m = Integer.parseInt(br.readLine());
            boolean[][] map = new boolean[m + 2][3];

            for (int j = 0; j < m; j++) {
                char[] line = br.readLine().toCharArray();
                map[j + 2] = new boolean[] {line[0] == 'x', line[1] == 'x', line[2] == 'x'};
            }

            int out = search(map);

            if (out >= 0) {
                System.out.println("YES " + out);
            } else {
                System.out.println("NO");
            }

            //System.out.println(search(map));
        }
    }

    private static int search(boolean[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];

        Queue<int[]> queue = new LinkedList<>();
        // x, y, k

        queue.add(new int[] {0, 0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int x = current[0];
            int y = current[1];
            int k = current[2];

            // check bounds
            if (y < 0 || x < 0 || x > 1) {
                continue;
            }

            if (visited[y][x]) {
                continue;
            }
            visited[y][x] = true;

            // check collision
            if (map[y][x] || map[y+1][x] || map[y][x+1] || map[y+1][x+1])
                continue;

            if (y == map.length - 2) {
                return k;
            }

            queue.add(new int[] {x, y + 1, k + 1});
            queue.add(new int[] {x - 1, y, k + 1});
            queue.add(new int[] {x + 1, y, k + 1});
        }
        return -1;
    }
}
