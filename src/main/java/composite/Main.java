package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式 树状结构专用模式
 *
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/10/10 13:39
 * @descrption
 */

abstract class Node {
    abstract public void p();
}

//叶子节点
class LeafNode extends Node {
    String content;

    public LeafNode(String content) {
        this.content = content;
    }

    @Override
    public void p() {
        System.out.println(content);
    }
}

//根节点
class BranchNode extends Node {
    List<Node> nodes = new ArrayList<>();

    String name;

    public BranchNode(String name) {
        this.name = name;
    }

    @Override
    public void p() {
        System.out.println(name);
    }

    public void add(Node n) {
        nodes.add(n);
    }
}

public class Main {
    public static void main(String[] args) {

        BranchNode root = new BranchNode("root");
        BranchNode chapter1 = new BranchNode("chapter1");
        BranchNode chapter2 = new BranchNode("chapter2");
        Node c11 = new LeafNode("c11");
        Node c12 = new LeafNode("c12");
        BranchNode b21 = new BranchNode("section21");
        Node c211 = new LeafNode("c211");
        Node c212 = new LeafNode("c212");

        root.add(chapter1);
        root.add(chapter2);
        chapter1.add(c11);
        chapter1.add(c12);
        chapter2.add(b21);
        b21.add(c211);
        b21.add(c212);

        tree(root, 0);
    }

    static void tree(Node n, int depth) {
        //深度 depth
        for(int i=0;i<depth;i++){
            System.out.print("--");
        }
        n.p();

        if (n instanceof BranchNode) {
            for (Node node : ((BranchNode) n).nodes) {
                tree(node, depth+1);
            }
        }
    }
}
