package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/strange-advertising/problem
 * <p>
 * <p>
 * results
 * https://www.hackerrank.com/challenges/strange-advertising/submissions/code/285393634
 */
@Slf4j
public class ViralAdvertisingTest {


    @Test
    public void test() {
        int[] targets = {3};

        Arrays.stream(targets).forEach(n -> {
            int result = viralAdvertising(n);
            log.info("## result : {}", result);
        });
    }


    public static int viralAdvertising(int n) {
        return recursive(1, n, 0, 5, 3, 0);

    }

    private static int recursive(int start, int target, int received, int firstSpread, int spread, int liked) {
        if (start > target) return liked;

        if (start == 1) {
            received = firstSpread;
        }

        int currentLike = received / 2;
        received = currentLike * spread;
        liked = liked + currentLike;
        start += 1;

        return recursive(start, target, received, firstSpread, spread, liked);

    }

}
