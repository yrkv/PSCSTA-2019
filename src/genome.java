import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// done
public class genome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/mnt/Judge/genome.in"));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            for (int j = word.length() - 1; j >= 0; j--) {
                String c = "" + word.charAt(j);
                switch (c) {
                    case "A":
                        System.out.print("T");
                        break;
                    case "C":
                        System.out.print("G");
                        break;
                    case "T":
                        System.out.print("A");
                        break;
                    case "G":
                        System.out.print("C");
                        break;
                }
            }
            System.out.println();
        }
    }
}
