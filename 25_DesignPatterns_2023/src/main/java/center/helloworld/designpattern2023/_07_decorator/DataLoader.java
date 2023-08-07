package center.helloworld.designpattern2023._07_decorator;

/**
 * @author zhishun.cai
 * @create 2023/7/13
 * @note
 */
public abstract class DataLoader {

    /**
     * 读取数据
     */
    public abstract String read();

    /**
     * 写入数据
     * @param data
     */
    public abstract void write(String data);
}
