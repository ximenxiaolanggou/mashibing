package center.helloworld.designpattern2023._07_decorator;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author zhishun.cai
 * @create 2023/7/13
 * @note
 */
public class BaseFileDataLoader extends DataLoader{


    @Override
    public String read() {

        try {
            return FileUtils.readFileToString(new File("demo.txt"), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void write(String data) {
        try {
            FileUtils.writeStringToFile(new File("demo.txt"), data, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
