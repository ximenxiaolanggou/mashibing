package top.damoncai.designattern.strategy.c_001comparable;

/**
 * @author zhishun.cai
 * @date 2021/1/21 17:24
 */

public class Sort {

    public void sort(Comparable[] objs) {
        for(int i = 0 ; i < objs.length - 1 ; i++) {
            for(int j = i + 1 ; j < objs.length ; j++) {
                if(objs[i].compareTo(objs[j]) > 0) {
                    swap(i,j,objs);
                }
            }
        }
    }

    /**
     * 数组交换位置数据
     * @param i
     * @param j
     * @param objs
     */
    private void swap(int i, int j, Comparable[] objs) {
        Comparable temp = objs[i];
        objs[i] =  objs[j];
        objs[j] = temp;
    }
}
