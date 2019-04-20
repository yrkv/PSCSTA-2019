import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

//done
public class secretword {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("Student/secretword.in"));
        BufferedReader br = new BufferedReader(new FileReader("/mnt/Judge/secretword.in"));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] words = br.readLine().split(" ");

            for (int j = 0; j < words.length; j++) {
                int index = words[j].length() - 1 - j;
                if (index < words[j].length() && index >= 0) {
                    System.out.print(words[j].charAt(index));
                }
            }
            System.out.println();
        }
    }
}
