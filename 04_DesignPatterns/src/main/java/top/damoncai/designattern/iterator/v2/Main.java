package top.damoncai.designattern.iterator.v2;

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
        System.out.println("================= LinkedList Iterator =================");
        Iterator_<Integer> iterator = myLinked.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }
    }

    private static void alTest() {
        Collection_<Integer> myArray = new ArrayList_<>();
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);
        System.out.println("myArray：" + myArray);
        System.out.println("Size：" + myArray.size());
        System.out.println("================= ArrayList Iterator =================");
        Iterator_<Integer> iterator = myArray.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }
    }
}
