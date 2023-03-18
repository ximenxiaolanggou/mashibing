package center.helloworld.designpattern2023._03_builder.example_01;

/**
 * @author zhishun.cai
 * @create 2023/3/15
 * @note
 */
public class Client {

    public static void main(String[] args) {

        HelloBuilder helloBuilder = new HelloBuilder();

        MoBaiBuilder moBaiBuilder = new MoBaiBuilder();

        Bike helloBike = new Director(helloBuilder).createBuilder();

        Bike moBaiBike = new Director(moBaiBuilder).createBuilder();

    }

}
