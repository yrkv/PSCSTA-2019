import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

// done
public class magicspell {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader( new FileReader("Student/magicspell.in"));
        BufferedReader br = new BufferedReader( new FileReader("/mnt/Judge/magicspell.in"));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());

        outer: for (int i = 0; i < N; i++) {
            HashMap<String, Integer> counts = new HashMap<>();
            st = new StringTokenizer(br.readLine());

            String bank = st.nextToken();
            String target = st.nextToken();

            for (String c : bank.split("")) {
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }

            for (String c : target.split("")) {
                if (counts.getOrDefault(c, 0) > 0) {
                    counts.put(c, counts.get(c) - 1);
                } else {
                    System.out.printf("Burp! Magic Spell cannot spell \"%s\" with the letters \"%s\"\n", target, bank);
                    continue outer;
                }
            }

            System.out.printf("Magic Spell spelled \"%s\" with the letters \"%s\"\n", target, bank);
        }
    }
}
