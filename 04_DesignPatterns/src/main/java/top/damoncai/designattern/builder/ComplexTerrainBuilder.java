package top.damoncai.designattern.builder;

/**
 * @author zhishun.cai
 * @date 2021/1/26 20:21
 */

public class ComplexTerrainBuilder implements TerrainBuilder {

    Terrain terrain = new Terrain();

    @Override
    public TerrainBuilder buildWall() {
        terrain.w = new Wall(1,2,3,4);
        return this;
    }

    @Override
    public TerrainBuilder buildFort() {
        terrain.f = new Fort(1,2,3,4);
        return this;
    }

    @Override
    public TerrainBuilder buildMine() {
        terrain.m = new Mine(1,2,3,4);
        return this;
    }

    @Override
    public Terrain builder() {
        return terrain;
    }
}
