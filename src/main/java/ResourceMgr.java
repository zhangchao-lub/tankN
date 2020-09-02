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
    public static BufferedImage tankU, tankD, tankL, tankR;
    public static BufferedImage enemyU, enemyD, enemyL, enemyR;
    public static BufferedImage bulletU, bulletD, bulletL, bulletR;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            tankU = ImageIO.read(new File("src/images/GoodTank1.png"));
            tankD = ImageUtil.rotateImage(tankU,180);
            tankL = ImageUtil.rotateImage(tankU,-90);
            tankR = ImageUtil.rotateImage(tankU,90);
//            tankR= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("src/images/tankR.gif"));

            enemyU =ImageIO.read(new File("src/images/BadTank1.png"));
            enemyD =ImageUtil.rotateImage(enemyU,180);
            enemyL =ImageUtil.rotateImage(enemyU,-90);
            enemyR =ImageUtil.rotateImage(enemyU,90);

            bulletU = ImageIO.read(new File("src/images/bulletU.gif"));
            bulletD = ImageIO.read(new File("src/images/bulletD.gif"));
            bulletL = ImageIO.read(new File("src/images/bulletL.gif"));
            bulletR = ImageIO.read(new File("src/images/bulletR.gif"));

            for (int i = 0; i < 16; i++)
                explodes[i]=ImageIO.read(new File("src/images/e"+(i+1)+".gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
