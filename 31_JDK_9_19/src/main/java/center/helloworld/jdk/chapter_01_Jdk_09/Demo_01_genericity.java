package center.helloworld.jdk.chapter_01_Jdk_09;

import java.util.Comparator;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note 泛型下推
 */
public class Demo_01_genericity {

    public static void main(String[] args) {
        Comparator<String> comparable = new Comparator<>(){
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };
    }
}
