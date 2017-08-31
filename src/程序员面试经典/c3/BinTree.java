package 程序员面试经典.c3;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Administrator on 2017/3/16.
 */
public class BinTree {
    /**
     * 前序遍历
     * @param parent
     */
    public static void preOrder(TreeNode parent) {
        if (parent == null)
            return;
        System.out.println(parent.val);
        preOrder(parent.left);
        preOrder(parent.right);
    }

    /**
     * 前序遍历的非递归实现
     * @param parent
     */
    public static void preOrder2(TreeNode parent) {
        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        queue.add(new TreeNode(5));
        queue.add(new TreeNode(6));
        queue.remove();
        System.out.println(queue.peek().val);
        TreeNode head = parent;
        
    }

    /**
     * 中序遍历
     * @param parent
     */
    public static void inOrder(TreeNode parent) {
        if (parent == null)
            return;
        inOrder(parent.left);
        System.out.println(parent.val);
        inOrder(parent.right);
    }

    /**
     * 后序遍历
     * @param parent
     */
    public static void postOrder(TreeNode parent) {
        if (parent == null)
            return;
        postOrder(parent.left);
        postOrder(parent.right);
        System.out.println(parent.val);
    }

    /**
     * 返回树的叶节点个数（深度）
     * @param parent
     */
    public static int leaves(TreeNode parent) {
        if (parent == null)
            return 0;
        if (parent.left == null && parent.right == null)
            return 1;
        return (parent.left == null ? 0 : leaves(parent.left)) + (parent.right == null ? 0 : leaves(parent.right));
    }

    public void  printTree(TreeNode root){

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(59);
        TreeNode node2 = new TreeNode(57,null,node1);
        TreeNode node3 = new TreeNode(45);
        TreeNode node4 = new TreeNode(55,node3,node2);
        TreeNode node5 = new TreeNode(101);
        TreeNode node6 = new TreeNode(107,node5,null);
        TreeNode node7 = new TreeNode(67);
        TreeNode node8 = new TreeNode(100,node7,node6);
        TreeNode node9= new TreeNode(60,node4,node8);

        System.out.println("前序遍历");
        preOrder(node9);
        System.out.println("中序遍历");
        inOrder(node9);
        System.out.println("后序遍历");
        postOrder(node9);

        System.out.println("--"+leaves(node9));

        preOrder2(node1);
    }


}
