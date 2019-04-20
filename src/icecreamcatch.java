import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

//done
public class icecreamcatch {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("Student/icecreamcatch.in"));
        BufferedReader br = new BufferedReader(new FileReader("/mnt/Judge/icecreamcatch.in"));

        StringTokenizer st  = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

//            int[] max = new int[m];
//            int[] min = new int[m];

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                min = Math.min(Integer.parseInt(st.nextToken()), min);
                max = Math.max(Integer.parseInt(st.nextToken()), max);
//                min[j] = Integer.parseInt(st.nextToken());
//                max[j] = Integer.parseInt(st.nextToken());
            }

            System.out.printf("%d %d %d\n", min, max, max-min+1);
        }
    }
}
