package top.damoncai.designattern.iterator.v2;

import lombok.ToString;

/**
 * @author zhishun.cai
 * @date 2021/1/26 13:40
 */

@ToString
public class ArrayList_<E> implements Collection_<E> {

    private E[] arrs = (E[]) new Object[3];

    private int index = 0;

    @Override
    public void add(E e) {
        if(index == arrs.length){
            //两倍扩容
            E[] arrs = (E[]) new Object[index * 2];
            System.arraycopy(this.arrs,0,arrs,0,index);
            this.arrs = arrs;
            System.out.println("扩容成功~~ size：" + arrs.length);
        }
        arrs[index] = e;
        index ++;
    }

    @Override
    public int size() {
        return arrs.length;
    }

    // iterator返回迭代器对象，不同数据结构各自维护自己的hasNext和next方法
    @Override
    public Iterator_ iterator() {
        return new ArrayListIterator();
    }

    // ArrayListIterator无需对外暴露使用
    private class ArrayListIterator<E> implements Iterator_<E> {

        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < index;
        }

        @Override
        public E next() {
            E e = (E) arrs[currentIndex];
            currentIndex ++;
            return e;
        }
    }
}
