package top.damoncai.basics.class04;

/**
 * 双向链表实现双端队列
 */
public class Code05_Double_List_To_Queue {

    public static void main(String[] args) {
    }

    public static class Queue<V> {
        Node<V> head = null;
        Node<V> tail = null;
        Integer size = 0;

        /**
         * 头部添加
         * @param v
         */
        public void headPush(V v) {
            Node<V> cur = new Node<V>(v);
            if(head == null) {
                head = cur;
                tail = cur;
            }else {
                head.last = cur;
                head = cur;
            }
            size ++;
        }

        /**
         * 尾部添加
         * @param v
         */
        public void tailPush(V v) {
            Node<V> cur = new Node<V>(v);
            if(head == null) {
                head = cur;
                tail = cur;
            }else {
                tail.next = cur;
                tail = cur;
            }
            size ++;
        }

        /**
         * 头部取出
         * @return
         */
        public V headPop() {
            V ans = null;
            if(head == null) return ans;

            ans = head.value;
            size -- ;

            if(head == tail) {
                head = null;
                tail = null;
            }else {
                head = head.next;
                head.last = null;
            }
            return ans;
        }

        /**
         * 尾部取出
         * @return
         */
        public V tailPop() {
            V ans = null;
            if(tail == null) return ans;

            ans = tail.value;
            size -- ;

            if(head == tail) {
                head = null;
                tail = null;
            }else {
                tail = head.last;
                tail.next = null;
            }
            return ans;
        }

    }

    public static class Node<V> {
        public V value;
        public Node<V> next;
        public Node<V> last;

        public Node(V value) {
            this.value = value;
        }
    }
}
