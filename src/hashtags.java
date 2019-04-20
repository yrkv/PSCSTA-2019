import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

// done
public class hashtags {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/mnt/Judge/hashtags.in"));
//        BufferedReader br = new BufferedReader(new FileReader("Student/hashtags.in"));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            String[] words = br.readLine().split(" ");
//            System.out.println(Arrays.toString(words));

            for (String word : words) {
                if (word.startsWith("#")) {
                    word = word.replaceFirst("#", "");
                    word = word.replaceFirst("[^a-zA-Z].*", "");
                    if (word.length() > 0) {
                        System.out.print(word + " ");
                    }
                }
            }
            System.out.println();

        }
    }
}
