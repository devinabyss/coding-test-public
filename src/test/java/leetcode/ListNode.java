package leetcode;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ToString
public class ListNode {
    public int val;

    public ListNode next;

    public ListNode() {
    }


    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public List<Integer> nodeValues() {
        List<Integer> list = new ArrayList<>();

        ListNode cur = this;

        while (Objects.nonNull(cur)) {
            list.add(cur.val);
            cur = cur.next;
        }
        return list;
    }
}
