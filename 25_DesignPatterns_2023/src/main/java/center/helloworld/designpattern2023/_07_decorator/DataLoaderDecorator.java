package center.helloworld.designpattern2023._07_decorator;

/**
 * @author zhishun.cai
 * @create 2023/7/13
 * @note
 */
public class DataLoaderDecorator extends DataLoader{

    private DataLoader dataLoader;

    public DataLoaderDecorator(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

    @Override
    public String read() {
        return dataLoader.read();
    }

    @Override
    public void write(String data) {
        dataLoader.write(data);
    }
}
