package top.damoncai.designattern.iterator.v1;

import lombok.Data;
import lombok.ToString;

import java.util.Collection;

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

    @ToString
    private class Node<E> {
         E e;
         Node<E> next;
    }
}
