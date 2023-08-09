package center.helloworld.jdk.chapter_01_Jdk_09;

import center.helloworld.jdk.entity.Person;
import org.junit.Test;

import java.io.*;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note try语法升级
 */
public class Demo_03_try {

    /**
     * try 通用写法
     */
    @Test
    public void common() {
        // 普通写法
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File("/"));
            fos = new FileOutputStream(new File("/"));
        }catch (Exception e) {

        }finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * java 8写法
     */
    @Test
    public void try8() {
        try(FileInputStream fis = new FileInputStream(new File("/"));
            FileOutputStream fos = new FileOutputStream(new File("/"));) {

        }catch (Exception e) {

        }
    }

    /**
     * java 9写法
     */
    @Test
    public void try9() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(new File("/"));
        FileOutputStream fos = new FileOutputStream(new File("/"));
        try(fis;fos){

        }catch (Exception e) {

        }
    }

}
