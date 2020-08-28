import org.junit.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/8/28 17:33
 * @descrption
 */
class ImageTest {

    @Test
    void test(){
        try {
            BufferedImage image=ImageIO.read(new File("src/images/bulletD.gif"));
            assertNotNull(image);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //fail("Not yet implemented")
    }
}
