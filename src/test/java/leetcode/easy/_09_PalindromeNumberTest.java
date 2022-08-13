package leetcode.easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@Slf4j
public class _09_PalindromeNumberTest {


    @Test
    public void test() {
        int[] tcs = {121, -121, 123, 10, 12321};

        Arrays.stream(tcs).forEach(tc -> {
            boolean result = isPalindrome(tc);
            log.info("## result : {}", result);
        });
    }


    public boolean isPalindrome(int x) {

        if (x < 0) return false;

        if (x / 10 == 0) return true;

        String str = String.valueOf(x);
        int length = str.length();
        boolean isDouble = length % 2 == 0;

        int spot = length / 2;

        int preLast = spot;
        int postFirst = isDouble ? spot : spot + 1;

        char[] pre = str.substring(0, preLast).toCharArray();
        char[] post = str.substring(postFirst).toCharArray();

        boolean isPalindrome = true;
        for (int i = 0; i < pre.length; i++) {
            if (pre[i] != post[post.length - i -1]) return false;
        }

        return isPalindrome;
    }
}
