import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/8/31 8:51
 * @descrption
 */
public class ResourceMgr {
//     static BufferedImage heroU = null;
//     static BufferedImage heroD = null;
//     static BufferedImage heroL = null;
//     static BufferedImage heroR = null;
//     static BufferedImage enemyU = null;
//     static BufferedImage enemyD = null;
//     static BufferedImage enemyL = null;
//     static BufferedImage enemyR = null;
//     static BufferedImage bulletU = null;
//     static BufferedImage bulletD = null;
//     static BufferedImage bulletL = null;
//     static BufferedImage bulletR = null;
//     static BufferedImage[] explodes = new BufferedImage[16];

    //    static {
//        try {
//            heroU = ImageIO.read(ResourceMgr.class.getResourceAsStream("GoodTank1.png"));
//            heroD = ImageUtil.rotateImage(heroU, 180);
//            heroL = ImageUtil.rotateImage(heroU, -90);
//            heroR = ImageUtil.rotateImage(heroU, 90);
////            tankR= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("src/images/tankR.gif"));
//
//            enemyU = ImageIO.read(ResourceMgr.class.getResourceAsStream("BadTank1.png"));
//            enemyD = ImageUtil.rotateImage(enemyU, 180);
//            enemyL = ImageUtil.rotateImage(enemyU, -90);
//            enemyR = ImageUtil.rotateImage(enemyU, 90);
//
//            bulletU = ImageIO.read(ResourceMgr.class.getResourceAsStream("bulletU.png"));
//            bulletD = ImageUtil.rotateImage(bulletU, 180);
//            bulletL = ImageUtil.rotateImage(bulletU, -90);
//            bulletR = ImageUtil.rotateImage(bulletU, 90);
//
//            for (int i = 0; i < 16; i++)
//                explodes[i] = ImageIO.read(ResourceMgr.class.getResourceAsStream("e" + (i + 1) + ".gif"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static BufferedImage getHeroU() {
//        return heroU;
//    }
//
//    public static BufferedImage getHeroD() {
//        return heroD;
//    }
//
//    public static BufferedImage getHeroL() {
//        return heroL;
//    }
//
//    public static BufferedImage getHeroR() {
//        return heroR;
//    }
//
//    public static BufferedImage getEnemyU() {
//        return enemyU;
//    }
//
//    public static BufferedImage getEnemyD() {
//        return enemyD;
//    }
//
//    public static BufferedImage getEnemyL() {
//        return enemyL;
//    }
//
//    public static BufferedImage getEnemyR() {
//        return enemyR;
//    }
//
//    public static BufferedImage getBulletU() {
//        return bulletU;
//    }
//
//    public static BufferedImage getBulletD() {
//        return bulletD;
//    }
//
//    public static BufferedImage getBulletL() {
//        return bulletL;
//    }
//
//    public static BufferedImage getBulletR() {
//        return bulletR;
//    }
//
//    public static BufferedImage[] getExplodes() {
//        return explodes;
//    }
    private ResourceMgr() {

    }

    private static class ResourceMgrHolder {
        private static BufferedImage heroU = null;
        private static BufferedImage heroD = null;
        private static BufferedImage heroL = null;
        private static BufferedImage heroR = null;
        private static BufferedImage enemyU = null;
        private static BufferedImage enemyD = null;
        private static BufferedImage enemyL = null;
        private static BufferedImage enemyR = null;
        private static BufferedImage bulletU = null;
        private static BufferedImage bulletD = null;
        private static BufferedImage bulletL = null;
        private static BufferedImage bulletR = null;
        private static BufferedImage[] explodes = new BufferedImage[16];

        static {
            try {
                heroU = ImageIO.read(ResourceMgr.class.getResourceAsStream("GoodTank1.png"));
                heroD = ImageUtil.rotateImage(heroU, 180);
                heroL = ImageUtil.rotateImage(heroU, -90);
                heroR = ImageUtil.rotateImage(heroU, 90);
//            tankR= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("src/images/tankR.gif"));

                enemyU = ImageIO.read(ResourceMgr.class.getResourceAsStream("BadTank1.png"));
                enemyD = ImageUtil.rotateImage(enemyU, 180);
                enemyL = ImageUtil.rotateImage(enemyU, -90);
                enemyR = ImageUtil.rotateImage(enemyU, 90);

                bulletU = ImageIO.read(ResourceMgr.class.getResourceAsStream("bulletU.png"));
                bulletD = ImageUtil.rotateImage(bulletU, 180);
                bulletL = ImageUtil.rotateImage(bulletU, -90);
                bulletR = ImageUtil.rotateImage(bulletU, 90);

                for (int i = 0; i < 16; i++)
                    explodes[i] = ImageIO.read(ResourceMgr.class.getResourceAsStream("e" + (i + 1) + ".gif"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static BufferedImage getHeroU() {
        return ResourceMgrHolder.heroU;
    }

    public static BufferedImage getHeroD() {
        return ResourceMgrHolder.heroD;
    }

    public static BufferedImage getHeroL() {
        return ResourceMgrHolder.heroL;
    }

    public static BufferedImage getHeroR() {
        return ResourceMgrHolder.heroR;
    }

    public static BufferedImage getEnemyU() {
        return ResourceMgrHolder.enemyU;
    }

    public static BufferedImage getEnemyD() {
        return ResourceMgrHolder.enemyD;
    }

    public static BufferedImage getEnemyL() {
        return ResourceMgrHolder.enemyL;
    }

    public static BufferedImage getEnemyR() {
        return ResourceMgrHolder.enemyR;
    }

    public static BufferedImage getBulletU() {
        return ResourceMgrHolder.bulletU;
    }

    public static BufferedImage getBulletD() {
        return ResourceMgrHolder.bulletD;
    }

    public static BufferedImage getBulletL() {
        return ResourceMgrHolder.bulletL;
    }

    public static BufferedImage getBulletR() {
        return ResourceMgrHolder.bulletR;
    }

    public static BufferedImage[] getExplodes() {
        return ResourceMgrHolder.explodes;
    }
}
