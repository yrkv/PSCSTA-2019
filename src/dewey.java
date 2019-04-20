import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;


//done
public class dewey {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/mnt/Judge/dewey.in"));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String[] words = new String[n];
            for (int j = 0; j < n; j++) {
                words[j] = st.nextToken();
            }

            Arrays.sort(words, (a, b) -> (a.charAt(2) - b.charAt(2)) * 10000 + (a.charAt(0) - b.charAt(0)) * 100 + (a.charAt(1) - b.charAt(1)));

            for (String w : words) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }
}
