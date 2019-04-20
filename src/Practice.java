import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Practice {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("/mnt/Judge/problem.in"));
        BufferedReader br = new BufferedReader(new FileReader("Student/repeat.in"));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            for (int j = 0; j < count; j++) {
                System.out.printf("%s ", word);
            }
            System.out.println();
        }
    }
}
