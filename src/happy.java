import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

// done
public class happy {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("Student/happy.in"));
        BufferedReader br = new BufferedReader(new FileReader("/mnt/Judge/happy.in"));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] nums = new int[n];

            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
                sum += nums[j];
            }

            double avg = sum / (double) n;

            int best = 0;
            double diff = Math.abs(avg - nums[0]);

            for (int j = 0; j < n; j++) {
                double diffCurrent = Math.abs(avg - nums[j]);
                if (diffCurrent < diff) {
                    diff = diffCurrent;
                    best = j;
                }
            }

            System.out.printf("Person %d with score %d is the most average happy person.\n", best + 1, nums[best]);
        }
    }
}
