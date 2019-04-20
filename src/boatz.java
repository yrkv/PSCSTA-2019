import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

//done
public class boatz {
    private static class Hand {
        String name;
        int[] cards = new int[5];

        public Hand(StringTokenizer st) {
            name = st.nextToken();
            cards[0] = Integer.parseInt(st.nextToken());
            cards[1] = Integer.parseInt(st.nextToken());
            cards[2] = Integer.parseInt(st.nextToken());
            cards[3] = Integer.parseInt(st.nextToken());
            cards[4] = Integer.parseInt(st.nextToken());
            Arrays.sort(cards);
        }

        @Override
        public String toString() {
            return name;
        }

        public int value() {
            int base = 40;
            int c = 12;
            int val = 0;
            boolean[] qualify = new boolean[] {false, false, false, false, false};
            // 5 of kind
            if (cards[0] == cards[1] && cards[1] == cards[2] && cards[2] == cards[3] && cards[3] == cards[4]) {
                val += base * c*c*c*c*c;
                qualify = new boolean[] {true, true, true, true, true};
            }

            // straight
            if (cards[0] == 1 && cards[1] == 2 && cards[2] == 3 && cards[3] == 4 && cards[4] == 5) {
                val += base * c*c*c*c;
                qualify = new boolean[] {true, true, true, true, true};
            }
            if (cards[0] == 2 && cards[1] == 3 && cards[2] == 4 && cards[3] == 5 && cards[4] == 6) {
                val += base * c*c*c*c;
                qualify = new boolean[] {true, true, true, true, true};
            }

            // 4 of kind
            if (cards[0] == cards[1] && cards[1] == cards[2] && cards[2] == cards[3]) {
                val += base * c*c*c;
                qualify = new boolean[] {true, true, true, true, false};
            }
            if (cards[1] == cards[2] && cards[2] == cards[3] && cards[3] == cards[4]) {
                val += base * c*c*c;
                qualify = new boolean[] {false, true, true, true, true};
            }

            // full house
            if (cards[0] == cards[1] && cards[1] == cards[2] && cards[3] == cards[4]) {
                val += base * c*c;
                qualify = new boolean[] {true, true, true, true, true};
            }
            if (cards[0] == cards[1] && cards[2] == cards[3] && cards[3] == cards[4]) {
                val += base * c*c;
                qualify = new boolean[] {true, true, true, true, true};
            }

            // 3 of kind
            for (int i = 0; i < 3; i++) {
                if (cards[i] == cards[i + 1] && cards[i + 1] == cards[i + 2]) {
                    val += base * c;
                    qualify[i] = true;
                    qualify[i+1] = true;
                    qualify[i+2] = true;
                }
            }

            // 2 of kind
            for (int i = 0; i < 4; i++) {
                if (cards[i] == cards[i + 1]) {
                    val += base;
                    qualify[i] = true;
                    qualify[i+1] = true;
                }
            }

            if (val == 0) {
                qualify = new boolean[] {true, true, true, true, true};
            }

            for (int i = 0; i < cards.length; i++) {
                if (qualify[i]) {
                    int x = cards[i];
                    val += x;
                }
            }

            return val;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/mnt/Judge/boatz.in"));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int m = Integer.parseInt(br.readLine());
            Hand[] hands = new Hand[m];

            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                hands[j] = new Hand(st);
            }

            Arrays.sort(hands, (a, b) -> b.value() - a.value());
            System.out.println(hands[0] + " wins the Boat-Z game");
        }
    }
}
