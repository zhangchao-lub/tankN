package builder;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/6 13:58
 * @descrption
 */
public class ComplexTerrainBuilder implements TerrainBuilder {
    Terrain terrain=new Terrain();

    @Override
    public TerrainBuilder builderWall() {
        terrain.w=new Wall(10,10,50,50);
        return this;
    }

    @Override
    public TerrainBuilder builderFort() {
        terrain.w=new Wall(10,10,50,50);
        return this;
    }

    @Override
    public TerrainBuilder builderMine() {
        terrain.w=new Wall(10,10,50,50);
        return this;
    }

    @Override
    public Terrain build() {
        return terrain;
    }
}
