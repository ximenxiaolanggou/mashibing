package top.damoncai.juc.c_021_03_VarHandle;

import java.lang.invoke.MethodHandles;
//import java.lang.invoke.VarHandle;

public class T01_HelloVarHandle {

    int x = 8;

//    private static VarHandle handle;

    static {
        try {
//            handle = MethodHandles.lookup().findVarHandle(T01_HelloVarHandle.class, "x", int.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        T01_HelloVarHandle t = new T01_HelloVarHandle();

        //plain read / write
//        System.out.println((int)handle.get(t));
//        handle.set(t,9);
        System.out.println(t.x);

//        handle.compareAndSet(t, 9, 10);
        System.out.println(t.x);

//        handle.getAndAdd(t, 10);
        System.out.println(t.x);

    }
}
