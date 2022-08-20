package hackerrank.easy;


import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/picking-numbers
 * <p>
 * completes
 * https://www.hackerrank.com/challenges/picking-numbers/submissions/code/285707104
 */
@Slf4j
public class PickingNumbersTest {

    public static int pickingNumbers(List<Integer> a) {

        Collections.sort(a);


        int largest = 0;

        for (int i = 0; i < a.size() - 1; i++) {
            int start = i;
            int end = a.size() - 1;
            int count = 0;
            while (start <= end) {

                int curStart = a.get(start);
                int curEnd = a.get(end);
                System.out.println("count : " + count + ", largeste : " + largest + ", curStart : " + curStart + ", curEnd : " + curEnd);
                int sum = Math.abs(curStart - curEnd);

                if (sum > 1) {
                    end--;
                    count = 0;
                } else {
                    count++;
                    if (count > largest) largest = count;
                    start++;
                }

            }

        }

        return largest; //> 0 ? largest + 1 : largest;


    }
}
