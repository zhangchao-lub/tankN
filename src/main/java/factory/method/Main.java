package factory.method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/11 9:37
 * @descrption
 */
public class Main {
    private final static Logger logger= LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("ok");
        Moveable c=CarFactory.getInstance().create();
        c.go();
    }
}
