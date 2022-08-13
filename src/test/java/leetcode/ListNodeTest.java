package leetcode;

import java.util.Objects;

public abstract class ListNodeTest {

    protected ListNode generateListNode(int[] arr) {

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
