package hackerrank.easy;

import lombok.extern.slf4j.Slf4j;

/**
 * https://www.hackerrank.com/challenges/counting-valleys
 *
 * results
 * https://www.hackerrank.com/challenges/counting-valleys/submissions/code/285703080
 */
@Slf4j
public class CountingValleysTest {





    public static int countingValleys(int steps, String path) {
        //d = 68 , u = 85

        char[] chars = path.toCharArray();

        int count = 0;
        int sea = 0;
        int before = sea;
        boolean continuing = false;

        for (int i = 0; i < chars.length; i++) {
            int cur = before;
            if (chars[i] == 85) {
                cur += 1;
                if (continuing) {
                    continuing = downContinuing(cur);
                }
            } else {
                cur -= 1;
                if (cur < sea && !continuing){
                    count++;
                    continuing = true;
                }
            }
            before = cur;
        }
        return count;
    }

    private static boolean downContinuing(int downPosition) {
        return downPosition < 0;
    }
}
