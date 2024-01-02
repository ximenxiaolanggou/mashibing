package center.helloworld.algorithm.systemrevivw;

/**
 * @author zhishun.cai
 * @create 2024/1/2
 * @note
 */
public class LLForStack {

    DoubleNode head;

    public void add(Integer ele) {
        DoubleNode node = new DoubleNode(ele);
        if(head == null) {
            head = node;
        }else {

            node.next = head;
            head.last = node;
            head = node;
        }
    }

    public Integer poll() {
        if(head == null) {
            return null;
        }
        Integer ans = head.value;
        head = head.next;

        if(head != null)
            head.last = null;

        return ans;
    }

    // 获取数据
    public Integer peek() {
        return head == null ? null : head.value;
    }
}
