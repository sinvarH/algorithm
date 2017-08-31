package 剑指offer.牛客网顺序;

import java.util.*;

/**
 * Created by Administrator on 7/24/2017.
 */
public class ReplaceSpac {
    public static String replaceSpace(StringBuffer str) {
        char[] charStr =str.toString().toCharArray();
        int spaceNum = 0;
        for (int i = 0 ;i<charStr.length;i++){
            if (charStr[i]==' ')
                spaceNum ++;
        }

        int oldSize = str.length();
        int newSize = str.length()+spaceNum*2;
        char[] newCharStr = new char[newSize];

        //两个指针
        int oldPonit = oldSize-1 ,newPoint =newSize-1;
        while (newPoint>=0){
            if (charStr[oldPonit]== ' '){
                newCharStr[newPoint--] ='0';
                newCharStr[newPoint--] ='2';
                newCharStr[newPoint--] ='%';
                oldPonit--;
            }else {
                newCharStr[newPoint--] = charStr[oldPonit--];
            }
        }
        ArrayList list = new ArrayList();
        return new String(newCharStr);
    }






    static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
   }

    /**
     * 输入一个链表，从尾到头打印链表每个节点的值。
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        while(listNode!=null){
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;

    }




    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和
     * 中序遍历的结果中都不含重复的数字
     * 。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int rootValue = pre[0];
        TreeNode root = reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    public TreeNode reConstructBinaryTree(int [] pre,int preStart,int preEnd,int [] in,int inStart,int inEnd) {
        //检查是否为空
        if (preStart>preEnd||inStart>inEnd)
            return null;
        TreeNode treeNode = new TreeNode(pre[preStart]);

        for (int i = inStart;i<=inEnd;i++){
            if (pre[preStart] == in[i]){
                //参考剑指offer
                treeNode.left = reConstructBinaryTree(pre,preStart+1,preStart+i-inStart,in,inStart,i-1);
                treeNode.right = reConstructBinaryTree(pre,preStart+i-inStart+1,preEnd,in,i+1,inEnd);
            }
        }
        return treeNode;
    }


    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        int index1 = 0 ;
        int index2 = array.length-1;
        int indexMid = index1;
        while (array[index1]>=array[index2]){
            if (index2-index1==1){
                indexMid= index2;
                break;
            }
            indexMid = (index1+index2)/2;
            if (array[indexMid]==array[index1]&&array[indexMid]==array[index2]){
                int min = array[0];
                for (int i = 1;i<array.length;i++){
                    if (array[i]<min){
                        min = array[i];
                    }
                }
                return min;
            }
            if (array[indexMid]>=array[index1])
                index1 = indexMid;
            else if (array[indexMid]<= array[index2])
                index2 = indexMid;
        }
        return array[indexMid];
    }


    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
     n<=39
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        int[] result = {0,1};
        if (n<2){
            return result[n];
        }
        int f1 = 0;
        int f2 = 1;
        int N  = 0;
        for (int i = 2 ;i<=n;i++){
            N = f1+f2;

            f1 = f2;
            f2 = N;
        }
        return N;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        int [] result = {1,2};
        if (target<3){
            return result[target-1];
        }

        int f1 = 1;
        int f2 = 2;
        int n = 0 ;
        for (int i = 3;i<=target;i++){
            n = f1+f2;
            f1 = f2;
            f2 = n;
        }
        return n;
    }


    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     *
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target==0)
            return 0;
      //横放竖放
        int [] result = {1,2};
        if (target<3){
            return result[target-1];
        }

        int f1 = 1;
        int f2 = 2;
        int n = 0 ;
        for (int i = 3;i<=target;i++){
            n = f1+f2;
            f1 = f2;
            f2 = n;
        }
        return n;
    }


    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int num = 0 ;
        int flag = 1;
        while (flag!=0){
            if ((flag&n)!=0)
                num++;
            flag<<=1;
        }
        return num;
    }

    /**
     * 快速幂
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        double res = 1;
        int temp = exponent;
        if (exponent==0)
            return 1;
        else if (exponent<0){
            temp = -exponent;
        }
        while (temp!=0){
            if ((temp&1)!=0){
                res *= base;
            }
            base*=base;
            temp>>=1;
        }
        if (exponent<0)
            return 1/res;
        return res;
    }

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数
     * ，偶数和偶数之间的相对位置不变。
     * 相对位置不变这个有点难度，以后想不需要空间的
     * @param array
     */
    public void reOrderArray(int [] array) {
        int[] temp = new int[array.length];
        int cur = 0;
        for (int i = 0;i<array.length;i++){
            if ((array[i]&1)==1)
                temp[cur++] = array[i];
        }
        for (int i = 0;i<array.length;i++){
            if ((array[i]&1)==0)
                temp[cur++] = array[i];
        }
        for (int i = 0;i<array.length;i++){
            array[i] = temp[i];
        }
    }



    public ListNode FindKthToTail(ListNode head,int k) {
        if (head==null||k<=0)
            return null;
        ListNode quick = head;
        ListNode slow = head;
        for(int i =1 ;i<k;i++){
            if (quick.next!=null)
                quick = quick.next;
            else return null;
        }
        while(quick.next!=null){
            slow = slow.next;
            quick = quick.next;
        }
        return slow;
    }

    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
     * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length==0)
            return false;
        Stack<Integer> stack1 = new Stack<>();
        //用于标识弹出序列的位置
        int popIndex =0;
        for (int i =0;i<pushA.length;i++){
            stack1.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while (!stack1.empty()&& stack1.peek()==popA[popIndex]){
                stack1.pop();
                popIndex++;
            }
        }
        return stack1.isEmpty();


    }


    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0)
            return false;
        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }

    public boolean VerifySquenceOfBST(int [] sequence,int start,int end ) {
        if (start==end)
            return true;
        int root = sequence[end];
        int i = start;
        for (;i<end;i++){
            if (sequence[i]>root)
                break;
        }
        for (int j = i;j<end;j++){
            if (sequence[j]<root)
                return false;
        }

        boolean left = true;
        if (i>0){
            left = VerifySquenceOfBST(sequence,start,i-1);
        }
        boolean right = true;
        if(i<end){
            right = VerifySquenceOfBST(sequence,i,end-1);
        }
        return left&right;

    }


    /**
     * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * @param root
     * @param target
     * @return
     */

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        return findPath(root,target,arrayList,lists);
    }

    ArrayList<ArrayList<Integer>> findPath(TreeNode root,
                                           int target, ArrayList<Integer> list,
                                           ArrayList<ArrayList<Integer>> container){
        if (root == null)
            return container;
        list.add(root.val);
        target -= root.val;
        //如果是叶节点并且等于target；
        if (target == 0&&root.left ==null&&root.right==null){
            container.add(new ArrayList<>(list));
        }
        //如果不是叶节点，遍历子节点
        if (root.left!=null) {
            findPath(root.left, target, list, container);
        }
        if (root.right!=null) {
            findPath(root.right, target, list, container);
        }
        //返回父节点时，在路径上删除当前节点
        list.remove(list.size()-1);
        return container;
    }


    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来
     * 的所有字符串abc,acb,bac,bca,cab和cba。
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        char[] sChar = str.toCharArray();
        ArrayList<String> arrayList = new ArrayList<>();
        if (str.length()==0){
            return arrayList;
        }
        arrayList = Permutation(arrayList,0,sChar);
        //加sort，不然结果CBA在CAB前面
        Collections.sort(arrayList);
        return  arrayList;

    }
    ArrayList<String> Permutation(ArrayList<String> list,int i,char[]str){
        if (i==str.length-1) {
            list.add(new String(str));
            return list;
        }else {
            //和后面的交换，包括和自己交换
            for (int j = i; j<str.length;j++) {
                if (i==j||str[i]!=str[j]) {
                    char temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;

                    Permutation(list, i + 1, str);

                    temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
        return list;

    }

    int [] quickSort(int [] data,int start,int end){
        if (start<end){
            int mid = sort(data,start,end);
            quickSort(data,start,mid-1);
            quickSort(data,mid+1,end);
        }
        return data;
    }

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
     * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     * @param array
     * @param start
     * @param end
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array,int start,int end ) {
        if (array.length<1)
            return 0;
        int middle = array.length>>1;
        int index = sort(array,start,end);
        while (index!=middle){
            if (index>middle){
                end = index-1;
                index = sort(array,start,end);
            }else {
                start = index+1;
                index = sort(array,start,end);
            }
        }
        //检查是否超过一半
        int num = 0;
        for (int i = 0;i<array.length;i++){
            if (array[i]==array[middle])
                num++;
        }
        if (num<=middle)
            return 0;
        return array[middle];
    }




    int sort (int[] data,int start,int end ){
        int key = data[start];
        int head = start;
        int tail = end ;
        while (head < tail) {
                //这里是》=。不然有bug
                while (head < tail && data[tail] >= key)
                    tail--;
                data[head] = data[tail];
                while (head < tail && data[head] <= key)
                    head++;
                data[tail] = data[head];
            }
        data[head] = key;
        return head;
    }

    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字
     * ，则最小的4个数字是1,2,3,4,。
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k>input.length||input.length==0)
            return new ArrayList<>();
        int res = sort(input,0,input.length-1);
        int start =0;
        int end = input.length-1;
        while (res!=k-1){
            if (res>k-1){
                end = --res;
                sort(input,start,end);
            }else {
                start = ++res;
                sort(input,start,end);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0;i<=res;i++)
            arrayList.add(input[i]);
        return arrayList;
    }

    /**
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
     * 而'*'表示它前面的字符可以出现任意次（包含0次）
     * 。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
     * 但是与"aa.a"和"ab*a"均不匹配
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        if (str==null||pattern==null)
            return false;
        return matchCore(str,0,pattern,0);
    }
    boolean matchCore(char[] str,int strCurrent ,char[] pattern,int patternCurrent){
        if (strCurrent==str.length&&patternCurrent==pattern.length)
            return true;
        if (strCurrent!=str.length&&patternCurrent==pattern.length)
            return false;
        if (strCurrent+1< pattern.length&&pattern[strCurrent+1]=='*')
            if (str[strCurrent]==pattern[patternCurrent]|| (pattern[patternCurrent]=='.'&&str[strCurrent]!=str.length)){
                return matchCore(str,strCurrent+1,pattern,patternCurrent+2)||
                        matchCore(str,strCurrent+1,pattern,patternCurrent)||
                        matchCore(str,strCurrent,pattern,patternCurrent+2);
            }else
                return matchCore(str,strCurrent,pattern,patternCurrent+2);
        if (str[strCurrent]==pattern[patternCurrent]||(pattern[patternCurrent]=='.'&&strCurrent!=str.length))
            return matchCore(str,strCurrent+1,pattern,patternCurrent+1);

        return false;
    }


    /**
     * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
     * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
     * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
     * 连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？
     * (子向量的长度至少是1)
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array==null||array.length==0)
            return 0;
        int len = array.length;
        int[] dp = new int[len];
        dp[0] = array[0] ;
        int max = dp[0];
        for(int i = 1;i<len;i++){
            if (array[i]>array[i]+dp[i-1])
                dp[i] = array[i];
            else
                dp[i] = array[i]+dp[i-1];
            max = Math.max(max,dp[i]);
        }
        return max;
    }


    /**
     * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
     * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
     * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0 ;
        for (int i = 1;i<=n;i++){
            count += getCount(i);
        }
        return count;
    }

    int getCount (int num){
        int n = 0;
        while (num>0){
            if (num%10==1)
                n++;
            num = num/10;
        }
        return n;
    }

    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
     * 则打印出这三个数字能排成的最小数字为321323。
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {
        if (numbers.length==0)
            return "";
        ArrayList<String> arrayList = permutation(new ArrayList<String>(),0,numbers);
        Collections.sort(arrayList);
        return arrayList.get(0);
    }

    /**
     * 类似字符串的排列这道题
     * @param list
     * @param begin
     * @param data
     * @return
     */
    ArrayList<String> permutation(ArrayList<String> list,int begin ,int [] data){
        if (begin==data.length-1) {
               list.add(arrayToString(data));
            return list;
        }
        for (int i = begin;i<data.length;i++){
            if (i==begin||data[i]!=data[begin]) {
                int temp = data[begin];
                data[begin] = data[i];
                data[i] = temp;

                permutation(list,begin+1,data);

                temp = data[begin];
                data[begin] = data[i];
                data[i] = temp;
            }
        }
        return list;

    }

    /**
     * 把正整数数组转化成String
     * @param data
     * @return
     */
    String arrayToString(int[] data){
        StringBuilder s = new StringBuilder();
        for (int i=0;i<data.length;i++){
           s.append(data[i]);
        }
        return s.toString();
    }

    /**
     * 在一个字符串(1<=字符串长度<=10000，
     * 全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0;i<str.length();i++){
            if (hashMap.get(str.charAt(i))==null)
                hashMap.put(str.charAt(i),1);
            else
                hashMap.put(str.charAt(i),hashMap.get(str.charAt(i))+1);
        }
       for (int i = 0;i<str.length();i++) {
           Integer a = hashMap.get(str.charAt(i));
           if (a == 1)
               return i;
       }
       return -1;
    }

    /**
     *把只包含因子2、3和5的数称作丑数（Ugly Number）。
     * 例如6、8都是丑数，但14不是，因为它包含因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     * @param index
     */
    public int GetUglyNumber_Solution(int index) {
        if (index<7)
            return index;
        int[] array = new int[index];
        array[0] =1;
        int t2 = 0,t3=0,t5 = 0,i;
        for (i = 1;i<index;i++){
            array[i] = min(array[t2]*2,array[t3]*3,array[t5]*5);
            if (array[i] ==array[t2]*2) t2++;
            if (array[i] ==array[t3]*3) t3++;
            if (array[i] ==array[t5]*5) t5++;
        }
        return array[index-1];
    }

    int min(int a ,int b ,int c ){
        int min = Math.min(a,b);
        min = Math.min(min,c);
        return min;
    }



    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7,0};
        int a = 1+'0';
        char b = (char)a;
        ReplaceSpac r = new ReplaceSpac();
//        System.out.println(r.InversePairs(array));
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        System.out.println(r.min(n));

    }

    /**
     * 小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。
     * 可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。
     * 如果不能购买恰好n个苹果，小易将不会购买。
     * @param n
     * @return
     */
    int min(int n ){
        if (n<6||((n^1)==1))
            return -1;
        int x = n/8;
        if (x*8==n)
            return x;
        for (int i = x;i>=0;i--){
            int y = (n-2*i)/6;
            if (y*6==n-2*i){
                return  y;
            }
        }
        return -1;
    }


    /**
     * 逆序对
     * @param array
     * @return
     */
    public int InversePairs(int [] array) {
        if(array==null||array.length==0)
        {
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i=0;i<array.length;i++)
        {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array,copy,0,array.length-1);//数值过大求余
        return count;

    }
    private int InversePairsCore(int[] array,int[] copy,int low,int high)
    {
        if(low==high)
        {
            return 0;
        }
        int mid = (low+high)>>1;
        int leftCount = InversePairsCore(array,copy,low,mid)%1000000007;
        int rightCount = InversePairsCore(array,copy,mid+1,high)%1000000007;
        int count = 0;
        int i=mid;
        int j=high;
        int locCopy = high;
        while(i>=low&&j>mid)
        {
            if(array[i]>array[j])
            {
                count += j-mid;
                copy[locCopy--] = array[i--];
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
            }
            else
            {
                copy[locCopy--] = array[j--];
            }
        }
        for(;i>=low;i--)
        {
            copy[locCopy--]=array[i];
        }
        for(;j>mid;j--)
        {
            copy[locCopy--]=array[j];
        }
        for(int s=low;s<=high;s++)
        {
            array[s] = copy[s];
        }
        return (leftCount+rightCount+count)%1000000007;
    }


    /**
     * 统计一个数字在排序数组中出现的次数。
     * @param array
     * @param k
     * @return
     */
    public  int GetNumberOfK(int[] array,int k){
        if(array==null||array.length==0)
            return 0;
        int first=getFirstK(array,k,0,array.length-1);
        int last=getLastK(array,k,0,array.length-1);
        if(first==-1 ||last==-1){
            return 0;
        }
        else{
            return last-first+1;
        }

    }

    public  int getFirstK(int[] array,int k,int start,int end){
        while(start<=end){
            int mid=(start+end)/2;
            if(k<array[mid])
                end=mid-1;
            else if(k>array[mid])
                start=mid+1;
            else{
                if((mid>0&&array[mid-1]!=k)||mid==0)
                    return mid;
                else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }

    public  int getLastK(int[] array,int k ,int start,int end){
        while(start<=end){
            int mid=(start+end)/2;
            if(k<array[mid])
                end=mid-1;
            else if(k>array[mid])
                start=mid+1;
            else{
                if((mid<array.length-1&&array[mid+1]!=k)||mid==array.length-1)
                    return mid;
                else{
                    start=mid+1;
                }
            }
        }
        return -1;
    }

    /**
     * 输入一棵二叉树，求该树的深度。
     * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     * @param pRoot
     * @return
     */
    public int TreeDepth(TreeNode pRoot)
    {
        if(pRoot == null){
            return 0;
        }
        int left = TreeDepth(pRoot.left);
        int right = TreeDepth(pRoot.right);
        return Math.max(left, right) + 1;
    }


    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     */
    private boolean isBalanced=true;
    public boolean IsBalanced_Solution(TreeNode root) {

        getDepth(root);
        return isBalanced;
    }
    public int getDepth(TreeNode root){
        if(root==null)
            return 0;
        int left=getDepth(root.left);
        int right=getDepth(root.right);

        if(Math.abs(left-right)>1){
            isBalanced=false;
        }
        return right>left ?right+1:left+1;

    }






    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * @param
     * @return
     */

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {


        if(array == null || array.length <= 1){
            num1[0] = num2[0] = 0;
            return;
        }
        int len = array.length, index = 0, sum = 0;
        for(int i = 0; i < len; i++){
            sum ^= array[i];
        }
        for(index = 0; index < 32; index++){
            if((sum & (1 << index)) != 0) break;
        }
        for(int i = 0; i < len; i++){
            if((array[i] & (1 << index))!=0){
                num2[0] ^= array[i];
            }else{
                num1[0] ^= array[i];
            }
        }


    }

    /**
     * 数组a中只有一个数出现一次，其他数都出现了2次，找出这个数字
     * @param a
     * @return
     */
    public  int find1From2(int[] a){
        int len = a.length, res = 0;
        for(int i = 0; i < len; i++){
            res = res ^ a[i];
        }
        return res;
    }


    /**
     * 数组a中只有一个数出现一次，其他数字都出现了3次，找出这个数字
     * @param a
     * @return
     */
    public  int find1From3(int[] a){
        int[] bits = new int[32];
        int len = a.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < 32; j++){
                bits[j] = bits[j] + ( (a[i]>>>j) & 1);
            }
        }
        int res = 0;
        for(int i = 0; i < 32; i++){
            if(bits[i] % 3 !=0){
                res = res | (1 << i);
            }
        }
        return res;
    }


    /**
     *链接：https://www.nowcoder.com/questionTerminal/11b018d042444d4d9ca4914c7b84a968
     来源：牛客网

     约瑟夫问题是一个非常著名的趣题，即由n个人坐成一圈，按顺时针由1开始给他们编号。然后由第一个人开始报数，数到m的人出局。现在需要求的是最后一个出局的人的编号。
     给定两个int n和m，代表游戏的人数。请返回最后一个出局的人的编号。保证n和m小于等于1000。


     把n个人的编号改为0~n-1，然后对删除的过程进行分析。
     第一个删除的数字是(m-1)%n，几位k，则剩余的编号为(0,1,...,k-1,k+1,...,n-1)，下次开始删除时，顺序为(k+1,...,n-1,0,1,...k-1)。
     用f(n,m)表示从(0~n-1)开始删除后的最终结果。
     用q(n-1,m)表示从(k+1,...,n-1,0,1,...k-1)开始删除后的最终结果。
     则f(n,m)=q(n-1,m)。

     下面把(k+1,...,n-1,0,1,...k-1)转换为(0~n-2)的形式，即
     k+1对应0
     k+2对于1
     ...
     k-1对应n-2
     转化函数设为p(x)=(x-k-1)%n, p(x)的你函数为p^(x)=(x+k+1)%n。
     则f(n,m)=q(n-1,m)=p^(f(n-1,m))=(f(n-1,m)+k+1)%n，又因为k=(m-1)%n。
     f(n,m)=(f(n-1,m)+m)%n;

     最终的递推关系式为
     f(1,m) = 0;                        (n=1)
     f(n,m)=(f(n-1,m)+m)%n; （n>1）

     代码如下：

     */


    public class Joseph {
/*
     * 编号为(0~n-1)
     */
        public int getResult(int n, int m) {
if (n < 0 || m < 0) {}
int last = 0;
for(int i=2;i<=n;++i){
    last = (last+m)%i;}
            // 因为实际编号为(1~n)
             return (last+1);
}
    }


}
