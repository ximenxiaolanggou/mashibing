package top.damoncai.designattern.iterator.v1;

import java.util.Collection;

/**
 * @author zhishun.cai
 * @date 2021/1/26 13:52
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("================= ArrayList Test =================");
        alTest();
        System.out.println("================= LinkedList Test =================");
        llTest();
    }

    private static void llTest() {
        Collection_<Integer> myLinked = new LinkedList_<>();
        myLinked.add(1);
        myLinked.add(2);
        myLinked.add(3);
        myLinked.add(4);
        System.out.println("myLinked" + myLinked);
        System.out.println("Size" + myLinked.size());
    }

    private static void alTest() {
        Collection_<Integer> myArray = new ArrayList_<>();
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);
        System.out.println("myArray" + myArray);
        System.out.println("Size" + myArray.size());
    }
}
