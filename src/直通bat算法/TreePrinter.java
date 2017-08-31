package 直通bat算法;

import 程序员面试经典.c3.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/3/24.
 */
public class TreePrinter {
    public static int[][] printTree(TreeNode root){
        if (root==null)
            return null;

        TreeNode last = root;
        TreeNode nlast = null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> values = new ArrayList<>();//保存节点的值
        ArrayList<ArrayList<Integer>> layer = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode r = queue.poll();
            values.add(r.val);
            if (r.left!=null) {
                queue.add(r.left);
                nlast = r.left;
            }
            if (r.right!=null) {
                queue.add(r.right);
                nlast = r.right;
            }

            //last 出队的时候，更新last为nlast;
            if (r == last){
                layer.add(values);
                values = new ArrayList<>();
                last = nlast;
            }
        }
        int [][] num = new int[layer.size()][];
        for (int i = 0 ;i<layer.size();i++){
            int length = layer.get(i).size();
            num[i] = new int[length];
            for (int j = 0;j<length;j++){
                num[i][j] = layer.get(i).get(j);
            }
        }

        return num;
    }

    public static void main(String[] args) throws InterruptedException {
        TreeNode node1 = new TreeNode(59,null,null);
        TreeNode node2 = new TreeNode(57,null,node1);
        TreeNode node3 = new TreeNode(45);
        TreeNode node4 = new TreeNode(55,node3,node2);
        TreeNode node5 = new TreeNode(101);
        TreeNode node6 = new TreeNode(107,node5,null);
        TreeNode node7 = new TreeNode(67);
        TreeNode node8 = new TreeNode(100,node7,node6);
        TreeNode node9= new TreeNode(60,node4,node8);

        for (int[] i :
             printTree(node9)) {
            for (int j:i) {
                System.out.print(j+"  ");
            }
            System.out.print("\n");
        }
    }
}
