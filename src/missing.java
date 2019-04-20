import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

//done
public class missing {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("Student/missing.in"));
        BufferedReader br = new BufferedReader(new FileReader("/mnt/Judge/missing.in"));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            System.out.println(IntStream.rangeClosed(a, b).sum() - Y);
        }
    }
}
