package top.damoncai.basics.class04;

/**
 * 单列 实现队列
 */
public class Code03_Singly_List_To_Queue {

    public static void main(String[] args) {
    }

    public static class Queue<V> {
        Node<V> head = null;
        Node<V> tail = null;
        Integer size = 0;

        /**
         * 添加元素
         * @param v
         */
        public void offer(V v) {
            Node<V> cur = new Node(v);
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
         * 获取但不删除元素
         * @return
         */
        public V peek() {
            V ans = null;
            if(head != null) {
                ans = head.value;
            }
            return ans;
        }

        /**
         * 获取并删除元素
         * @return
         */
        public V poll() {
            V ans = null;
            if(head != null) {
                ans = head.value;
                head = head.next;
                size --;
            }
            if(head == null) {
                tail = null;
            }
            return ans;
        }
    }

    public static class Node<V> {
        public V value;
        public Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }
}
