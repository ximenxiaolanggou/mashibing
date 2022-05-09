package top.damoncai.basics.class01;

/**
 * @author zhishun.cai
 * @date 2021/2/27 10:44
 */

public class   Code04_BSExist {

    public static void main(String[] args) {
        int[] arrs = {1,2,3,4,5,9,11};
        int target = 5;
        binarySearch(arrs,target);
    }

    /**
     * 二分查找
     * @param arrs
     * @param target
     */
    private static void binarySearch(int[] arrs, int target) {
        int L = 0;
        int R = arrs.length -1;
        int mid = 0;

        while (L <= R) {
            mid = (L + R) / 2;
            int midNum = arrs[mid];
            if(midNum > target) {
                R = mid - 1;
            }else if (midNum < target){
                L = mid + 1;
            }else{
                System.out.println("Exist~~ " + mid);
                return;
            }
        }
    }
}
