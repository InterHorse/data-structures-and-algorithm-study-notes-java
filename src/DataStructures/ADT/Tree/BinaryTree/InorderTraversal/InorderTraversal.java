package DataStructures.ADT.Tree.BinaryTree.InorderTraversal;

import DataStructures.ADT.Tree.BinaryTree.BinaryNode;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/6/15
 * Time: 15:04
 */
public class InorderTraversal {

    /**
     * 中序遍历打印二叉树（递归）
     * @param rootNode
     */
    public void printTreeByInorderTraversal(BinaryNode rootNode) {
        if(rootNode.getLeft() != null) {
            printTreeByInorderTraversal(rootNode.getLeft());
        }
        System.out.print(rootNode.getElement().toString() + " ");
        if(rootNode.getRight() != null) {
            printTreeByInorderTraversal(rootNode.getRight());
        }
    }
}
