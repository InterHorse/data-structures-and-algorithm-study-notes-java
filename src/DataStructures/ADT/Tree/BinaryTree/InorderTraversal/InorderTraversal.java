package DataStructures.ADT.Tree.BinaryTree.InorderTraversal;

import DataStructures.ADT.Tree.BinaryTree.BinaryNode;

import java.util.Stack;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/6/15
 * Time: 15:04
 */
public class InorderTraversal {

    /**
     * 中序遍历打印二叉树（递归）
     *
     * @param rootNode
     */
    public void printTreeByInorderTraversal(BinaryNode rootNode) {
        if (rootNode.getLeft() != null) {
            printTreeByInorderTraversal(rootNode.getLeft());
        }
        System.out.print(rootNode.getElement().toString() + " ");
        if (rootNode.getRight() != null) {
            printTreeByInorderTraversal(rootNode.getRight());
        }
    }

    /**
     * 中序遍历打印二叉树（堆栈）
     * @param rootNode
     */
    public void printTreeByInorderTraversalStack(BinaryNode rootNode) {
        Stack<BinaryNode> stack = new Stack<>();
        while(rootNode != null || stack.size() > 0) {
            if(rootNode != null) {
                stack.push(rootNode);
                rootNode = rootNode.getLeft();
            } else {
                rootNode = stack.pop();
                System.out.print(rootNode.getElement().toString() + " ");
                rootNode = rootNode.getRight();
            }
        }
    }
}
