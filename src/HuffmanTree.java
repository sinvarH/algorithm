import java.util.*;

/**
 * Created by Administrator on 8/30/2017.
 */
public class HuffmanTree {
    /**
     * 节点类
     */
      static class HuffmanNode {
        private int val;
        public int data;
        public HuffmanNode left;
        public HuffmanNode right;

        public HuffmanNode(int data) {
            this.data = data;
        }

        public HuffmanNode(int data, HuffmanNode left) {
            this.data = data;
            this.left = left;
        }

        public HuffmanNode(int data, HuffmanNode left, HuffmanNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }

    //使用优先队列构造哈夫曼树
    PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(new Comparator<HuffmanNode>() {
        @Override
        public int compare(HuffmanNode node1, HuffmanNode node2) {
            int data1 = node1.data;
            int data2 = node2.data;
            if (data2<data1)
                return 1;
            if (data2>data1)
                return -1;
            return 0;
        }
    });
    HuffmanNode tree;
    public HuffmanTree(int[] nums){
        tree = init(nums);
        generateHuffmanTreeCode(tree);
    }
    /**
     * 初始化哈夫曼树
     * @param nums
     * @return
     */
    private HuffmanNode init(int[] nums){
        if (nums==null)
            return null;
        for (int i = 0;i<nums.length;i++){
            if (nums[i]!=0) {
                HuffmanNode node = new HuffmanNode(nums[i]);
                node.setVal(i);
                priorityQueue.add(node);
            }
        }
        while (priorityQueue.size()>1){
            HuffmanNode node1 = priorityQueue.poll();
            HuffmanNode node2 = priorityQueue.poll();
            HuffmanNode newNode = new HuffmanNode(node1.data+node2.data,node1,node2);
            priorityQueue.add(newNode);
        }
        return priorityQueue.poll();
    }

    public HuffmanNode getTree(){
        return tree;
    }

    //得到编码,类似二叉树的前缀遍历
    private List<Character> list = new ArrayList<>();
    private HashMap<Integer,String> hashMap = new HashMap<>();
    private HashMap<String,Integer> hashMap2 = new HashMap<>();
    String temp;
    private void generateHuffmanTreeCode(HuffmanTree.HuffmanNode node){
        if (node==null) {
            return;
        }
        if (node.left==null&&node.right==null){
            char[] str = new char[list.size()];
            for (int i = 0;i<str.length;i++){
                str[i] = list.get(i);
            }
            temp = new String(str);
            hashMap.put(node.val,temp);
            hashMap2.put(temp,node.val);
        }
        list.add('0');
        generateHuffmanTreeCode(node.left);
        list.remove(list.size() - 1);
        list.add('1');
        generateHuffmanTreeCode(node.right);
        list.remove(list.size() - 1);
    }

    /**
     * 得到哈夫曼路径编码的hashmap
     */
    public HashMap<Integer,String> getencodeMap(){
        generateHuffmanTreeCode(tree);
        return hashMap;
    }
    public HashMap<String,Integer> getDecodeMap(){
        return hashMap2;
    }
    public static void main(String[] args) {
        int[] test = {1, 1};
        HuffmanTree tree = new HuffmanTree(test);
        System.out.println(tree.getencodeMap());
        System.out.println(tree.getDecodeMap());
    }
}

