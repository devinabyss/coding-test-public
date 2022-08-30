package programmers.graph;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 타겟 넘버
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
@Slf4j
public class TargetNumberTest {


    @Test
    public void test() {
        int[][] numbers = {
                {1, 1, 1, 1, 1,}, {4, 1, 2, 1}
        };
        int[] targets = {3, 4};

        for (int i = 0; i < numbers.length; i++) {
            int result = solution(numbers[i], targets[i]);
            log.info("## result : {}", result);
        }
    }

    public int solution(int[] numbers, int target) {

        int answer = recursive(0, numbers, 0, target);

        return answer;
    }


    public int recursive(int pos, int[] numbers, int result, int target) {

        if (pos >= numbers.length) {
            return (result == target) ? 1 : 0;
            //return result;
        }

        return recursive(pos + 1, numbers, result + numbers[pos], target) + recursive(pos + 1, numbers, result - numbers[pos], target);

    }
}
