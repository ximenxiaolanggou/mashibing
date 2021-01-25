package top.damoncai.designattern.strategy.c_002comparator;

/**
 * @author zhishun.cai
 * @date 2021/1/21 17:24
 */

public class Sort<T> {

    public void sort(T[] objs,Comparator<T> comparator) {
        for(int i = 0 ; i < objs.length - 1 ; i++) {
            for(int j = i + 1 ; j < objs.length ; j++) {
                if(comparator.compareTo(objs[i],objs[j]) > 0) {
                    swap(i,j,objs);
                }
            }
        }
    }

    private void swap(int i, int j, T[] objs) {
        T temp = objs[i];
        objs[i] =  objs[j];
        objs[j] = temp;
    }
}
