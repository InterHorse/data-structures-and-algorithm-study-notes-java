package DataStructures.ADT.Tree.BinaryTree.PostorderTraversal;

import DataStructures.ADT.Tree.BinaryTree.BinaryNode;

/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/6/15
 * Time: 15:01
 */
public class PostorderTraversal {

    /**
     * 后续遍历打印二叉树（递归）
     * @param rootNode
     */
    public void printTreeByPostorderTraversal(BinaryNode rootNode) {
        if(rootNode.getLeft() != null) {
            printTreeByPostorderTraversal(rootNode.getLeft());
        }
        if(rootNode.getRight() != null) {
            printTreeByPostorderTraversal(rootNode.getRight());
        }
        System.out.print(rootNode.getElement().toString() + " ");
    }
}
