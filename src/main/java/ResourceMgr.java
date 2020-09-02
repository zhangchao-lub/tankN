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
    public static BufferedImage bulletU, bulletD, bulletL, bulletR;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            tankU = ImageIO.read(new File("src/images/tankU.gif"));
            tankD = ImageIO.read(new File("src/images/tankD.gif"));
            tankL = ImageIO.read(new File("src/images/tankL.gif"));
            tankR = ImageIO.read(new File("src/images/tankR.gif"));
//            tankR= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("src/images/tankR.gif"));

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
