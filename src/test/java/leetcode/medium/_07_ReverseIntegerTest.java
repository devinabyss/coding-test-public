package leetcode.medium;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reverse-integer/submissions/
 * <p>
 * results
 * https://leetcode.com/submissions/detail/774304887/ - use long
 * https://leetcode.com/submissions/detail/774306707/ - use numberformat exception
 */
@Slf4j
public class _07_ReverseIntegerTest {


    @Test
    public void test() {

        int[] tcs = {123, -123, 120, -2147483648, 1111111119};
        Arrays.stream(tcs).forEach(tc -> {
            int result = reverse(tc);
            log.info("## result : {}", result);
        });

    }


    public int reverse(int x) {

        boolean isMinus = x < 0;

        char[] absNumChars = String.valueOf(Math.abs(x)).toCharArray();

        if (absNumChars[0] == 45) return 0;

        log.info("## absNumChars : {}", absNumChars);


        char[] reversedChars = new char[absNumChars.length];

        log.info("## reversedChars : {}", reversedChars);

        for (int i = 0; i < absNumChars.length; i++) {
            reversedChars[reversedChars.length - 1 - i] = absNumChars[i];
        }

        String reversedStr = String.valueOf(reversedChars);

        try {
            int reversedLong = Integer.parseInt(reversedStr);
            return isMinus ? -reversedLong : reversedLong;
        } catch (NumberFormatException e) {
            return 0;
        }


    }
}
