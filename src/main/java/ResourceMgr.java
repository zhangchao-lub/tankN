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
    public static BufferedImage heroU, heroD, heroL, heroR;
    public static BufferedImage enemyU, enemyD, enemyL, enemyR;
    public static BufferedImage bulletU, bulletD, bulletL, bulletR;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            heroU = ImageIO.read(new File("src/images/GoodTank1.png"));
            heroD = ImageUtil.rotateImage(heroU, 180);
            heroL = ImageUtil.rotateImage(heroU, -90);
            heroR = ImageUtil.rotateImage(heroU, 90);
//            tankR= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("src/images/tankR.gif"));

            enemyU = ImageIO.read(new File("src/images/BadTank1.png"));
            enemyD = ImageUtil.rotateImage(enemyU, 180);
            enemyL = ImageUtil.rotateImage(enemyU, -90);
            enemyR = ImageUtil.rotateImage(enemyU, 90);

            bulletU = ImageIO.read(new File("src/images/bulletU.png"));
            bulletD = ImageUtil.rotateImage(bulletU, 180);
            bulletL = ImageUtil.rotateImage(bulletU, -90);
            bulletR = ImageUtil.rotateImage(bulletU, 90);

            for (int i = 0; i < 16; i++)
                explodes[i] = ImageIO.read(new File("src/images/e" + (i + 1) + ".gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
