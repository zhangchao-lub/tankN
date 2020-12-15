import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Properties;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/2 17:39
 * @descrption
 */
public class PropertyMgr {
    static Properties props = new Properties();

    private PropertyMgr(){

    }
    static {
        try {
//            BufferedImage image2= ImageIO.read(PropertyMgr.class.getResourceAsStream("bulletD.gif"));
            props.load(PropertyMgr.class.getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (props == null) {
            return null;
        }
        return props.get(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initTankCount"));

    }
}
