package algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@Slf4j
class StringPermutationTest {


    @Test
    public void test() {

        String[] result = StringPermutation.permutation("ACFJMNRT");
        log.info("## Result : {}, {}", result.length, Arrays.toString(result));

    }

}