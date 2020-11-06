package builder;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/6 14:30
 * @descrption 建造者模式 链式编程
 *             当我们要创建的对象很复杂的时候（通常是由很多其他的对象组合而成）使用该模式
 * 　　        使复杂对象的创建过程和这个对象的表示（展示）分离开来
 */
public class Main {
    public static void main(String[] args) {
        TerrainBuilder builder=new ComplexTerrainBuilder();
        Terrain t=builder.builderWall().builderFort().builderMine().build();

        Person p=new Person.PersonBuilder()
                .basicInfo(1,"zhangchao",26)
                .weight(130)
                .score(20000)
                .loc("曲江","9")
                .builder();
    }
}
