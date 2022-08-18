package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
 *
 *
 * completed
 */
@Slf4j
public class BeautifulDaysAtTheMoviesTest {


    @Test
    public void test() {

        int[] from = {20};
        int[] to = {23};
        int[] target = {6};

        for (int i = 0; i < from.length; i++) {
            int result = beautifulDays(from[i], to[i], target[i]);
            log.info("## result : {}", result);
        }

    }


    public static int beautifulDays(int i, int j, int k) {
        // Write your code here

        int count = 0;
        while (i <= j) {
            //int original = i;

            String original = String.valueOf(i);
            StringBuilder reversed = new StringBuilder();
            for (int a = original.length() - 1; a >= 0; a--) {
                reversed.append(original.charAt(a));
            }

            int value = Math.abs(i - Integer.parseInt(reversed.toString()));

            if (value % k == 0) count++;
            i++;
        }


        return count;

    }
}
