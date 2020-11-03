package ASM;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.FieldVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.io.IOException;

import static org.springframework.asm.Opcodes.ASM4;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/10/29 17:13
 * @descrption ASM 操作字节码
 */
public class ClassPrinter extends ClassVisitor {
    public ClassPrinter() {
        super(ASM4);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        System.out.println(name + " extends " + superName);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        System.out.println("    "+name);
        return super.visitField(access, name, descriptor, signature, value);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        System.out.println("    "+name+"()");
        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
        System.out.println("}");
    }

    public static void main(String[] args) throws IOException {
        ClassPrinter cp=new ClassPrinter();
        ClassReader cr=new ClassReader("java.lang.Runnable");

        cr.accept(cp,0);
    }
}
