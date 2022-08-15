package leetcode.easy;

import leetcode.ListNode;
import leetcode.ListNodeTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/submissions/
 * <p>
 * results
 * https://leetcode.com/submissions/detail/774343297/
 */
@Slf4j
public class _21_MergeTwoSortedListsTest extends ListNodeTest {

    @Test
    public void test() {

        ListNode result = mergeTwoLists(generateListNode(new int[]{}), generateListNode(new int[]{}));
        log.info("## result : {}, {}", result);

    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode result = null;
        ListNode before = null;
        while (list1 != null || list2 != null) {

            ListNode cur = new ListNode();

            int a = list1 == null ? Integer.MAX_VALUE : list1.val;
            int b = list2 == null ? Integer.MAX_VALUE : list2.val;

            if (a <= b && list1 != null) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
            }

            cur.val = Math.min(a, b);
            log.info("## cur : {}, before : {}", cur, before == null ? before : before.nodeValues());
            if (before == null) {
                before = cur;
                result = before;
                //before = before.next;
            } else {
                before.next = cur;
                before = before.next;


            }

        }

        return result;

    }
}
