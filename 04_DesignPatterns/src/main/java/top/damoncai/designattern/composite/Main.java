package top.damoncai.designattern.composite;

import java.util.Arrays;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * @author zhishun.cai
 * @date 2021/1/24 21:48
 */

public class Main {

    public static void main(String[] args) {
        BranchNode root = new BranchNode();
        root.setName("root");

        BranchNode leftRoot = new BranchNode();
        leftRoot.setName("1");

        LeafNode leafNode11 = new LeafNode();
        leafNode11.setName("1-1");
        LeafNode leafNode12 = new LeafNode();
        leafNode12.setName("1-2");
        leftRoot.setNodes(Arrays.asList(leafNode11,leafNode12));

        BranchNode rightRoot = new BranchNode();
        rightRoot.setName("2");

        LeafNode rightNode21 = new LeafNode();
        rightNode21.setName("2-1");
        LeafNode rightNode12 = new LeafNode();
        rightNode12.setName("2-2");
        rightRoot.setNodes(Arrays.asList(rightNode21,rightNode12));

        root.setNodes(Arrays.asList(leftRoot,rightRoot));

        System.out.println(root);

        printInfo(root);

    }

    private static void printInfo(Node node) {
        String name = node.getName();
        System.out.println(name);
        if(node instanceof BranchNode){
            BranchNode branchNode = (BranchNode) node;
            List<Node> childs = branchNode.getNodes();
            for (Node child : childs) {
                printInfo(child);
            }
        };
    }
}
