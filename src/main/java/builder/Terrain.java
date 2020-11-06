package builder;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/6 13:49
 * @descrption 地形
 */
public class Terrain {
    Wall w;//墙
    Fort f;//堡垒
    Mine m;//地雷
}
class Wall{
    int x,y,w,h;

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
}

class Fort{
    int x,y,w,h;

    public Fort(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
}

class Mine{
    int x,y,w,h;

    public Mine(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
}
