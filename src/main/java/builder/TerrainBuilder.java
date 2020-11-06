package builder;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/6 13:54
 * @descrption 地形构建器
 */
public interface TerrainBuilder {
    TerrainBuilder builderWall();
    TerrainBuilder builderFort();
    TerrainBuilder builderMine();
    Terrain build();

}
