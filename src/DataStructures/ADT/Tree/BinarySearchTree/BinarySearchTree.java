package DataStructures.ADT.Tree.BinarySearchTree;


/**
 * Created with IDEA
 * Author: MaYuzhe
 * Date: 2018/6/17
 * Time: 15:11
 * <p>
 * BinarySearchTree 二叉查找树
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    private static class BinaryNode<T> {

        BinaryNode(T t) {
            this(t, null, null);
        }

        BinaryNode(T t, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = t;
            this.left = left;
            this.right = right;
        }

        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;
    }

    private BinaryNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * 将树清空
     */
    public void makeEmpty() {
        this.root = null;
    }

    /**
     * 判断是否为空
     *
     * @return 为空则返回true，否则返回false
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean contais(T t) {
        return contains(t, root);
    }

    public T findMin() {
        if (isEmpty()) {
            return null;
        }
        return findMin(root).element;
    }

    public T findMax() {
        if (isEmpty()) {
            return null;
        }
        return findMax(root).element;
    }

    public void insert(T t) {
        root = insert(t, root);
    }

    public void remove(T t) {
        root = remove(t, root);
    }

    public void printTree() {
        if (isEmpty()) {
            System.out.println("空树/Empty tree");
        } else {
            printTree(root);
        }
        System.out.println();
    }


    /**
     * 中序遍历方式打印树
     *
     * @param node
     */
    private void printTree(BinaryNode<T> node) {
        if (node != null) {
            printTree(node.left);
            System.out.println(node.element);
            printTree(node.right);
        }
    }


    /**
     * 判断被判断的元素在节点哪侧，递归判断。
     *
     * @param t    被判断的元素
     * @param node 当前节点
     * @return 如果有相等的值则返回true。否则返回false
     */
    private boolean contains(T t, BinaryNode<T> node) {
        if (node == null) {
            return false;
        }
        int compareResult = t.compareTo(node.element);

        if (compareResult < 0) {
            return contains(t, node.left);
        } else if (compareResult > 0) {
            return contains(t, node.right);
        } else {
            return true;
        }
    }

    /**
     * 寻找最小节点（递归）
     *
     * @param node
     * @return
     */
    private BinaryNode<T> findMin(BinaryNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    /**
     * 寻找最大节点（递归）
     *
     * @param node
     * @return
     */
    private BinaryNode<T> findMax(BinaryNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.right == null) {
            return node;
        }
        return findMax(node.right);
    }

//    /**
//     * 寻找最小节点（非递归）
//     * @param node
//     * @return
//     */
//    private BinaryNode<T> findMin(BinaryNode<T> node) {
//        if(node != null) {
//            while (node.left != null) {
//                node = node.left;
//            }
//        }
//        return node;
//    }

//    /**
//     * 寻找最大节点（非递归）
//     * @param node
//     * @return
//     */
//    private BinaryNode<T> findMax(BinaryNode<T> node) {
//        if (node != null) {
//            while (node.right != null) {
//                node = node.right;
//            }
//        }
//        return node;
//    }

    /**
     * 插入操作
     *
     * @param t
     * @param node
     * @return
     */
    private BinaryNode<T> insert(T t, BinaryNode<T> node) {
        if (node == null) {
            return new BinaryNode<>(t, null, null);
        }

        int compareResult = t.compareTo(node.element);
        if (compareResult < 0) {
            node.left = insert(t, node.left);
        } else if (compareResult > 0) {
            node.right = insert(t, node.right);
        }
        return node;
    }

    /**
     * 删除节点
     *
     * @param t
     * @param node
     * @return
     */
    private BinaryNode<T> remove(T t, BinaryNode<T> node) {
        if (t == null) {
            return null;
        }
        int compareResult = t.compareTo(node.element);

        if (compareResult < 0) {
            node.left = remove(t, node.left);
        } else if (compareResult > 0) {
            node.right = remove(t, node.right);
        } else if (node.left != null && node.right != null) {
//            node.element = findMin(node.right).element;
//            node.right = remove(node.element, node.right);
            // 用removeRightMin方法替代上面两个操作，将两次遍历合并成一次遍历完成，提高效率
            node.right = removeRightMin(node, node.right);
        } else {
            node = node.left != null ? node.left : node.right;
        }
        return node;
    }

    /**
     * 删除右侧做小节点
     *
     * @param node
     * @param rNode
     * @return
     */
    private BinaryNode<T> removeRightMin(BinaryNode<T> node, BinaryNode<T> rNode) {
        if (rNode.left != null) {
            rNode.left = removeRightMin(node, rNode.left);
        } else {
            node.element = rNode.element;
            rNode = rNode.right;
        }
        return rNode;
    }
}
