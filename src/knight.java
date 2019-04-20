import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

//done
public class knight {
    private static class Point {
        int x, y;
        public Point(String in) {
            x = in.charAt(0) - 'A';
            y = in.charAt(1) - '1';
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Set<Point> moves() {
            HashSet<Point> moves = new HashSet<>();

            moves.add(new Point(x + 1, y + 2));
            moves.add(new Point(x + 1, y - 2));
            moves.add(new Point(x + 2, y + 1));
            moves.add(new Point(x + 2, y - 1));

            moves.add(new Point(x - 1, y + 2));
            moves.add(new Point(x - 1, y - 2));
            moves.add(new Point(x - 2, y + 1));
            moves.add(new Point(x - 2, y - 1));

            return moves;
        }

        @Override
        public String toString() {
            return (char) (x + 'A') + "" + (char) (y + '1');
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                Point o = (Point) obj;
                return x == o.x && y == o.y;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return x * 8 + y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/mnt/Judge/knight.in"));

        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            Set<Point> a = new Point(input[0]).moves();
            Set<Point> b = new Point(input[1]).moves();
            Set<Point> c = new Point(input[2]).moves();

            a.retainAll(b);
            a.retainAll(c);

            a.stream()
                    .filter(point -> point.x >= 0 && point.x < 8 && point.y >= 0 && point.y < 8)
                    .forEach(System.out::println);
        }
    }
}
