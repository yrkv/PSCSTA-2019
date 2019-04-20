import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

//done
public class beacon {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("Student/beacon.in"));
        BufferedReader br = new BufferedReader(new FileReader("/mnt/Judge/beacon.in"));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            System.out.println(search(0, 0, x, y, 1, 0));
        }
    }

    private static int search(int x, int y, int targetX, int targetY, int k, int dir) {
//        System.out.println("target_x: " + targetX + ", target_y: " + targetY);
        int c = 0;
        while (x != targetX || y != targetY) {
            if (k == 0) {
                dir += 1;
                k = (dir / 2) + 1;
            }

            switch (dir % 4) {
                case 0:
                    x += 1;
                    break;
                case 1:
                    y += 1;
                    break;
                case 2:
                    x -= 1;
                    break;
                case 3:
                    y -= 1;
                    break;
            }

//            System.out.println("x: " + x + ", y: " + y);

            k -= 1;
            c++;

            //if (x == targetX && y == targetY)
                //c++;
            //else {
                //return 1 + search(x, y, targetX, targetY, k - 1, dir);
            //}
        }
        return c;
    }
}
