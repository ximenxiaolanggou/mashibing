package top.damoncai.designattern.builder;

/**
 * @author zhishun.cai
 * @date 2021/1/26 20:20
 * @note
 */

public interface TerrainBuilder {

    TerrainBuilder buildWall();
    TerrainBuilder buildFort();
    TerrainBuilder buildMine();

    Terrain builder();
}
