package ASM;







import org.springframework.asm.ClassReader;
import org.springframework.asm.ClassVisitor;
import org.springframework.asm.ClassWriter;
import org.springframework.asm.MethodVisitor;

import java.io.File;
import java.io.FileOutputStream;

import static org.springframework.asm.Opcodes.ASM4;
import static org.springframework.asm.Opcodes.INVOKESTATIC;


/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/2 17:30
 * @descrption
 */
public class ClassTransformerTest {
    public static void main(String[] args) throws Exception {
        ClassReader cr = new ClassReader(ClassPrinter.class.getResourceAsStream("/ASM/Tank.class"));
        ClassWriter cw = new ClassWriter(0);
        ClassVisitor cv = new ClassVisitor(ASM4,cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                MethodVisitor mv=super.visitMethod(access,name,descriptor,signature,exceptions);
                return new MethodVisitor(ASM4,mv) {
                    @Override
                    public void visitCode() {
                        visitMethodInsn(INVOKESTATIC,"TimeProxy","before","()V",false);
                        super.visitCode();
                    }
                };
            }
        };

        cr.accept(cv,0);
        byte[] b2=cw.toByteArray();

        String path= (String) System.getProperties().get("user.dir");
        File f=new File(path+"/com/zhangchao/dp/ASM");
        f.mkdirs();

        FileOutputStream fos=new FileOutputStream(new File(path+"/com/zhangchao/dp/ASM/Tank_0.class"));
        fos.write(b2);
        fos.flush();
        fos.close();
    }
}
