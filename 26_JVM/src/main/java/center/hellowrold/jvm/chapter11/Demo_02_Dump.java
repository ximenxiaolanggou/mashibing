package center.hellowrold.jvm.chapter11;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhishun.cai
 * @create 2023/11/9
 * @note 获取Dump文件
 *
 */
public class Demo_02_Dump {

    public static void main(String[] args) throws InterruptedException {
        List<Object> numList = new ArrayList<>();
        Date birth = new Date();

        for (int i = 0; i < 100; i++) {
            numList.add(String.valueOf(i));
            Thread.sleep(10);
        }

        // 阻塞在这生成dumpq文件
        System.out.println("数据添加完毕，请操作：");
        new Scanner(System.in).next();

        numList = null;
        birth = null;

        // 阻塞在这生成dumpq文件
        System.out.println("numList、birth已清空，请操作：");
        new Scanner(System.in).next();
        System.out.println("over ~~~");
    }

}
