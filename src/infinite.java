import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class infinite {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/mnt/Judge/infinite.in"));
        int N = Integer.parseInt(br.readLine());


        out: for (int i = 0; i < N; i++) {
            int num = 0;
            int x = Integer.parseInt(br.readLine());
            int j = 1;
//            System.out.println("x:" + x);

            if (x == 1) {
                System.out.println(2);
                continue;
            }

            while (num <= x) {
                num += j;
//                System.out.println("num: " + num);
                j += 1;
                if (x == num || x == num + 1) {
                    System.out.println(3);
                    continue out;
                }
            }

            System.out.println(4);

        }
    }
}
