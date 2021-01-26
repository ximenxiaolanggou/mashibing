package top.damoncai.designattern.iterator.v2;

import lombok.ToString;

/**
 * @author zhishun.cai
 * @date 2021/1/26 14:19
 */

@ToString
public class LinkedList_<E> implements Collection_<E> {

    private Node node;

    private Node tail;

    private int index = 0;

    @Override
    public void add(E e) {
        Node<E> node = new Node<>();
        node.e = e;
        if(tail == null ) {
            this.node = node;
            this.tail = node;
        }
        tail.next = node;
        tail = node;
        index ++;
    }

    @Override
    public int size() {
        return this.index;
    }

    @Override
    public Iterator_ iterator() {
        return new LikedListIterator();
    }

    @ToString
    private class Node<E> {
         E e;
         Node<E> next;
    }

    private class LikedListIterator<E> implements Iterator_<E> {

        private Node<E> currentNode = node;

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < index;
        }

        @Override
        public E next() {
            currentIndex ++;
            E e = currentNode.e;
            currentNode = currentNode.next;
            return e;
        }
    }
}
