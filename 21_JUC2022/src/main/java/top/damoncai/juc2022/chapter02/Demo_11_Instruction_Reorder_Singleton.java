package top.damoncai.juc2022.chapter02;

/**
 * 指令重排序 单例
 */
public class Demo_11_Instruction_Reorder_Singleton {

    private static volatile Demo_11_Instruction_Reorder_Singleton test;

    private Demo_11_Instruction_Reorder_Singleton(){}

    public static Demo_11_Instruction_Reorder_Singleton getInstance(){
        // B
        if(test  == null){
            synchronized (Demo_11_Instruction_Reorder_Singleton.class){

                if(test == null){
                    // A   ,  开辟空间，test指向地址，初始化
                    test = new Demo_11_Instruction_Reorder_Singleton();
                }
            }
        }
        return test;
    }
}
