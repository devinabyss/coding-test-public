package leetcode.medium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * https://leetcode.com/problems/find-original-array-from-doubled-array/
 */
@Slf4j
public class _2007_FindOriginalArrayFromDoubledArray {


    @Test
    public void test() {

        int[][] tcs = {
                //{4,0,3,0}
                //{1, 2, 3, 2, 4, 6, 2, 4, 6, 4, 8, 12}
                {1, 3, 4, 2, 6, 8}, {6, 3, 0, 1}
        };


        Arrays.stream(tcs).forEach(tc -> {
            int[] result = findOriginalArray(tc);
            log.info("## result : {}", Arrays.toString(result));
        });
    }


    public int[] findOriginalArray(int[] changed) {

        if (changed.length % 2 != 0) {
            return new int[]{};
        }

        Arrays.sort(changed);

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> original = new ArrayList<>();

        for (Integer no : changed) {
            if (!queue.isEmpty() && queue.peek().equals(no)) {
                original.add(queue.poll() /2);
            } else {
                queue.add(no * 2);
            }
        }

        return original.size() == changed.length / 2 ? original.stream().mapToInt(Integer::intValue).toArray() : new int[]{};

    }


    public int[] findOriginalArray2(int[] changed) {

        if (changed.length % 2 != 0) {
            return new int[]{};
        }

        Arrays.sort(changed);

        log.info("## changed : {}", Arrays.toString(changed));

        Set<Integer> checked = new HashSet<>();
        List<Integer> original = new ArrayList<>();

        for (int i = 0; i < changed.length; i++) {


            if (checked.contains(i)) continue;

            int out = changed[i];

            //if (out == 0) return new int[]{};

            boolean isContinue = true;

            for (int j = i + 1; j < changed.length; j++) {

                if (checked.contains(j)) continue;

                int in = changed[j];

                if (in > out * 2) {
                    isContinue = false;
                    break;
                }

                if (in / 2 == out) {
                    checked.add(j);
                    original.add(out);
                    break;
                }
            }

            if (!isContinue) {
                return new int[]{};
            }
        }

        if (original.size() != changed.length / 2) {
            return new int[]{};
        }

        return original.stream().mapToInt(Integer::intValue).toArray();
    }

}
