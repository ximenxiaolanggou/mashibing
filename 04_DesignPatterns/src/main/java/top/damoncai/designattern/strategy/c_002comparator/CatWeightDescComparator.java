package top.damoncai.designattern.strategy.c_002comparator;

/**
 * @author zhishun.cai
 * @date 2021/1/21 18:24
 */

public class CatWeightDescComparator implements Comparator<Cat>  {

    @Override
    public int compareTo(Cat t0, Cat t1) {
        if (t0.getWeight() > t1.getWeight()) return -1;
        if (t0.getWeight() < t1.getWeight()) return 1;
        else return 0;
    }
}
