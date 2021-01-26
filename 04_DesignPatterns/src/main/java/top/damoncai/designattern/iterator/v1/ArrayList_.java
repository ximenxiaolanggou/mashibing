package top.damoncai.designattern.iterator.v1;

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
}
