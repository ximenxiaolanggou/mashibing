package top.damoncai.basics.class04;

/**
 * 单列 实现栈
 */
public class Code04_Singly_List_To_Stack {

    public static void main(String[] args) {
    }

    public static class Queue<V> {
        Node<V> head = null;
        Integer size = 0;

        /**
         * 添加元素
         * @return
         */
        public void push(V v) {
            Node cur = new Node(v);
            if(head == null) {
                head = cur;
            }else {
                cur.next = head;
                head = cur;
            }
            size ++;
        }

        /**
         * 获取并删除元素
         * @return
         */
        public V pop() {
            V ans = null;
            if(head != null) {
                ans = head.value;
                head = head.next;
                size --;
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
