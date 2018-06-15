package DataStructures.ADT.Tree.BinaryTree.PreorderTraversal;

import DataStructures.ADT.Tree.BinaryTree.BinaryNode;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/6/15
 * Time: 14:41
 */
public class PreorderTraversal {

    /**
     * 先序遍历打印二叉树（递归）
     * @param rootNode
     */
    public void printTreeByPreorderTraversal(BinaryNode rootNode) {
        System.out.print(rootNode.getElement().toString() + " ");
        if(rootNode.getLeft() != null) {
            printTreeByPreorderTraversal(rootNode.getLeft());
        }
        if(rootNode.getRight() != null) {
            printTreeByPreorderTraversal(rootNode.getRight());
        }
    }
}
