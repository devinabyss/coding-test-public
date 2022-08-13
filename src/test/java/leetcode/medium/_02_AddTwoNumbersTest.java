package leetcode.medium;

import leetcode.ListNode;
import leetcode.ListNodeTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * https://leetcode.com/problems/add-two-numbers/
 *
 * result
 * https://leetcode.com/submissions/detail/771985846/
 * https://leetcode.com/submissions/detail/373666643/
 */
@Slf4j
public class _02_AddTwoNumbersTest extends ListNodeTest {


    @Test
    public void test() {

        int[][] node1arr = {
                {2, 4, 3}, {0}, {9, 9, 9, 9, 9, 9, 9}
        };
        int[][] node2arr = {
                {5, 6, 4}, {0}, {9, 9, 9, 9}
        };

        for (int i = 0; i < node1arr.length; i++) {
            ListNode node1 = generateListNode(node1arr[i]);
            ListNode node2 = generateListNode(node2arr[i]);

            ListNode result = addTwoNumbers(node1, node2);
            log.info("## Result : {}", Objects.nonNull(result) ? result.nodeValues() : result);
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        log.info("## l1 : {}", l1.nodeValues());
        log.info("## l2 : {}", l2.nodeValues());

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int legacy = 0;
        ListNode result = null;
        ListNode resultBefore = null;
        while (Objects.nonNull(cur1) || Objects.nonNull(cur2)) {

            int val1 = 0;
            int val2 = 0;

            if (Objects.nonNull(cur1)) {
                //val1 += cur1.val * digits;
                val1 = cur1.val;
                cur1 = cur1.next;
            }

            if (Objects.nonNull(cur2)) {
                val2 = cur2.val;
                cur2 = cur2.next;
            }

            int sum = val1 + val2 + legacy;

            legacy = sum / 10;
            ListNode cur = new ListNode(sum % 10);

            if (Objects.isNull(result)) result = cur;
            if (Objects.nonNull(resultBefore)) {

                resultBefore.next = cur;
            }
            resultBefore = cur;

        }
        if (legacy > 0) {
            resultBefore.next = new ListNode(legacy);
        }

        return result;
    }


}
