package 剑指offer._22_02_链表中间节点;

/**
 * @author feichaoyu
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("[");
        for (ListNode cur = this; ; cur = cur.next) {
            if (cur == null) {
                ret.deleteCharAt(ret.lastIndexOf(" "));
                ret.deleteCharAt(ret.lastIndexOf(","));
                break;
            }
            ret.append(cur.val);
            ret.append(", ");
        }
        ret.append("]");
        return ret.toString();
    }
}
