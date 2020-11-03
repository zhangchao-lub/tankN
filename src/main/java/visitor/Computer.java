package visitor;


/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/10/29 10:03
 * @descrption  visitor模式 适用于结构固定的业务代码，
 *                         内部结构一旦形成永远不变，方便于新增外来对象。
 */
public class Computer {
    ComputerPart cpu=new CPU();
    ComputerPart memory=new Memory();
    ComputerPart board=new Board();

    public void accept(Visitor v){
        this.cpu.accept(v);
        this.memory.accept(v);
        this.board.accept(v);
    }
}

abstract class ComputerPart {
    abstract void accept(Visitor v);
    abstract double getPrice();

}

class CPU extends ComputerPart{

    @Override
    void accept(Visitor v) {
        v.visitCpu(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}

class Memory extends ComputerPart{

    @Override
    void accept(Visitor v) {
        v.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 300;
    }
}

class Board extends ComputerPart{

    @Override
    void accept(Visitor v) {
        v.visitBoard(this);
    }

    @Override
    double getPrice() {
        return 200;
    }
}

interface Visitor{
    void visitCpu(CPU cpu);
    void visitMemory(Memory memory);
    void visitBoard(Board board);
}

class PersonelVisitor implements Visitor{

    double totalPrice =0.0;
    @Override
    public void visitCpu(CPU cpu) {
        totalPrice+=cpu.getPrice()*0.9;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice+=memory.getPrice()*0.9;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice+=board.getPrice()*0.9;
    }
}

class CorpVisitor implements Visitor{

    double totalPrice =0.0;
    @Override
    public void visitCpu(CPU cpu) {
        totalPrice+=cpu.getPrice()*0.8;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice+=memory.getPrice()*0.8;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice+=board.getPrice()*0.8;
    }
}
