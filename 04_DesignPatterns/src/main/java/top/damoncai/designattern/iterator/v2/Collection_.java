package top.damoncai.designattern.iterator.v2;

/**
 * @author zhishun.cai
 * @date 2021/1/26 13:39
 */

public interface Collection_<E> {

    void add(E e);

    int size();

    Iterator_ iterator();
}
