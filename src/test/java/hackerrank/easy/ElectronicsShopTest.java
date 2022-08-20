package hackerrank.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/electronics-shop/
 * <p>
 * results
 * https://www.hackerrank.com/challenges/electronics-shop/submissions/code/285587495
 */
@Slf4j
public class ElectronicsShopTest {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        List<String> strs = new ArrayList<>();
        while (sc.hasNext()) {
            strs.add(sc.nextLine());
        }


        int budget = Integer.parseInt(strs.get(0).split(" ")[0]);

        int[] keyboards = Arrays.stream(strs.get(1).split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] drives = Arrays.stream(strs.get(2).split(" ")).mapToInt(Integer::parseInt).toArray();

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));

        for (int keyboard : keyboards) {
            for (int drive : drives) {
                int sum = keyboard + drive;
                if (sum <= budget) queue.add(sum);
            }
        }

        System.out.print(queue.isEmpty() ? -1 : queue.poll());

    }
}
