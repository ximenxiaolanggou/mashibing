package top.damoncai.designattern.builder;

/**
 * @author zhishun.cai
 * @date 2021/1/26 20:25
 */

public class Main {
    public static void main(String[] args) {
        TerrainBuilder builder = new ComplexTerrainBuilder();
        Terrain terrain = builder.buildFort().buildWall().buildMine().builder();
        System.out.println(terrain);

        Person person = new Person.PersonBuilder()
                .basicInfo(1, "damoncai", 2)
                .loc("沧浪街", "22")
                .build();

    }
}
