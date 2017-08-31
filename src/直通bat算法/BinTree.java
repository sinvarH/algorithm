package 直通bat算法;

import 程序员面试经典.c3.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Administrator on 2017/4/7.
 */
public class BinTree {
    public static void main(String[] args) {
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2,four,five);
        TreeNode three = new TreeNode(3,six,seven);
        TreeNode one = new TreeNode(1,two,three);

        TreeNode i = new TreeNode(4);
        TreeNode j = new TreeNode(3,i,null);
        TreeNode k = new TreeNode(1,null,j);


        preOrder(one);
        System.out.println();
        preOrder2(one);
        System.out.println();
        inOrder(one);
        System.out.println();
        inOrder2(one);
        System.out.println();
        lastOrder(one);
        System.out.println();
        lastOrder2(one);
        System.out.println();
        System.out.println(isBalance(k));
        System.out.println();
        System.out.println(chk(one));
    }

    static void preOrder(TreeNode parent){
        if (parent ==null)
            return;
        System.out.print(parent.val);
        preOrder(parent.left);
        preOrder(parent.right);
    }



    static void preOrder2(TreeNode parent){
        Stack<TreeNode> stack = new Stack<>();
        stack.add(parent);
        while (!stack.empty()){
            TreeNode node = stack.pop();
            System.out.print(node.val);
            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }
        }
    }

    static void inOrder(TreeNode parent){
        if (parent ==null)
            return;
        inOrder(parent.left);
        System.out.print(parent.val);
        inOrder(parent.right);
    }

    static void inOrder2(TreeNode parent){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = parent;
        while (cur!=null||!stack.empty()){
            if (cur!=null){
                stack.add(cur);
                cur = cur.left;
            }else {
                TreeNode node = stack.pop();
                System.out.print(node.val);
                cur = node.right;
            }
        }
    }

    static void lastOrder(TreeNode parent){
        if (parent ==null)
            return;
        lastOrder(parent.left);
        lastOrder(parent.right);
        System.out.print(parent.val);
    }

    static void lastOrder2(TreeNode parent){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(parent);
        while (!stack1.empty()){
            TreeNode node = stack1.pop();
            stack2.add(node);
            if (node.left!=null)
                stack1.add(node.left);
            if (node.right!=null)
                stack1.add(node.right);
        }
        while (!stack2.empty()){
            System.out.print(stack2.pop().val);
        }
    }

    //判断是否为平衡二叉树
    public static boolean isBalance(TreeNode head){
        boolean [] res = new boolean[1];
        res[0] = true;
        getHeight(head,1,res);
        return res[0];
    }

    public static int  getHeight(TreeNode head ,int level,boolean[] res){
        if (head == null)
            return level;
        int lH = getHeight(head.left,level+1,res);
        if (!res[0]){
            return level;
        }
        int rH = getHeight(head.right,level+1,res);
        if (!res[0]){
            return  level;
        }
        if (Math.abs(lH-rH)>1){
            res[0] = false;
        }
        return Math.max(lH,rH);
    }



    public static boolean chk(TreeNode root) {
            // write code here
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean mustLeaves = false;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (mustLeaves){
                if (node.right!=null||node.left!=null){
                    return false;
                }
            }
            if (node.right!=null&&node.left==null){
                return false;
            }
            if (!(node.left!=null&&node.right!=null)){
                mustLeaves = true;
            }
            if (node.left!=null)
                queue.add(node.left);
            if (node.right!=null){
                queue.add(node.right);
            }
        }
        return true;
    }
}
