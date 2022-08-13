package leetcode.easy;

import leetcode.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * LeetCode - 83. Remove Duplicates from Sorted List
 */
@Slf4j
public class RemoveDuplicatesFromSortedListTest {


    @Test
    public void test() {

        int[][] test1 = {{1, 1, 2}, {1, 1, 2, 3, 3}, {1}};

        for (int i = 0; i < test1.length; i++) {
            ListNode node = generateListNode(test1[i]);
            log.info("## Generated Node : {}", node);
            ListNode result = deleteDuplicates(node);
            log.info("## Result : {}", result);
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head;

        while (!Objects.isNull(cur)) {
            ListNode next = cur.next;
            log.info("## Next : {}", next);

            if (Objects.nonNull(next) && cur.val == next.val) {
                cur.next = next.next;
            } else {
                cur = next;
            }
        }


        return head;
    }


    private ListNode generateListNode(int[] arr) {

        ListNode tail = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            ListNode cur = new ListNode(arr[i]);
            if (!Objects.isNull(tail)) {
                cur.next = tail;
            }
            tail = cur;
        }
        return tail;
    }


}
