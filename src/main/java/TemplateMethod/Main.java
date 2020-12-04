package TemplateMethod;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/4 15:57
 * @descrption
 */
public class Main {
    public static void main(String[] args) {
        F f=new C1();
        f.m();
    }
}

abstract class F {
    public void m() {
        op1();
        op2();
    }
    abstract  void op1();
    abstract  void op2();
}

class C1 extends F{

    @Override
    void op1() {
        System.out.println("op1");
    }

    @Override
    void op2() {
        System.out.println("op2");

    }
}