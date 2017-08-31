/**
 * Created by Administrator on 2017/4/14.
 */
public class BTree2<Key extends Comparable<Key>,Value>{
        //
    private static final int M = 4;

    private Node root ;
    //height of the B-tree
    private int height ;
    //number of key-value pairs in the B-tree
    private int n ;

    static class Node{
        //number of children
        private int m ;
        //the array of children
        private Entry[] children = new Entry[M];

        public Node(int m) {
            this.m = m;
        }
    }

    private static class  Entry{
        private Comparable key;
        private  final Object val;

        // helper field to iterate over array entries
        private Node next;
        public Entry(Comparable key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Initializes an empty B-tree;
     */
    public BTree2() {
        root = new Node(0);
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public int size(){
        return  n;
    }
    public Value get (Key key){
        if (key==null) throw new IllegalArgumentException("argument to get() is null");
        return search(root,key,height);

    }
    private Value search(Node x,Key key,int ht ){
        Entry[] children = x.children;

        //external node
        if (ht == 0){
            for (int j = 0 ;j<x.m;j++){
                if (eq(key,children[j].key)){
                    return (Value) children[j].val;
                }
            }
        }
        // internal node
        else {
            for (int j = 0 ;j<x.m;j++){
                if (j+1 == x.m||less(key,children[j+1].key)){
                    return search(children[j].next,key,ht-1);
                }
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("argument key to put() is null");
        Node u = insert(root, key, val, height);
        n++;
        if (u == null) return;

        // need to split root
        Node t = new Node(2);
        t.children[0] = new Entry(root.children[0].key, null, root);
        t.children[1] = new Entry(u.children[0].key, null, u);
        root = t;
        height++;
    }


    private Node insert(Node h,Key key,Value val,int ht){
        int j ;
        Entry t = new Entry(key,val,null);
        // external node
        if (ht == 0){
            for (j =0;j<h.m;j++){
                if (less(key,h.children[j].key)) break;
            }
        }
        //internal node
        else{
            for (j = 0 ;j<h.m;j++){
                if ((j+1==h.m)||less(key,h.children[j+1].key)){
                    Node u = insert(h.children[j++].next,key,val,ht-1);
                    if (u == null)
                        return null;
                    t.key = u.children[0].key;
                    t.next = u;
                    break;
                }
            }
        }

        for (int i = h.m;i>j;i--){
            h.children[i] = h.children[i-1];
        }
        h.children[j] = t;
        h.m++;
        if (h.m<M) return  null;
        else return split(h);
    }

    // split node in half
    private Node split(Node h) {
        Node t = new Node(M/2);
        h.m = M/2;
        for (int j = 0; j < M/2; j++)
            t.children[j] = h.children[M/2+j];
        return t;
    }


    private boolean eq (Comparable k1,Comparable k2){
        return  k1.compareTo(k2) == 0;
    }

    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }
    public static void main(String[] args) {
        BTree<String, String> st = new BTree<String, String>();

        st.put("www.cs.princeton.edu", "128.112.136.12");
        st.put("www.cs.princeton.edu", "128.112.136.11");
        st.put("www.princeton.edu",    "128.112.128.15");
        st.put("www.yale.edu",         "130.132.143.21");
        st.put("www.simpsons.com",     "209.052.165.60");
        st.put("www.apple.com",        "17.112.152.32");
        st.put("www.amazon.com",       "207.171.182.16");
        st.put("www.ebay.com",         "66.135.192.87");
        st.put("www.cnn.com",          "64.236.16.20");
        st.put("www.google.com",       "216.239.41.99");
        st.put("www.nytimes.com",      "199.239.136.200");
        st.put("www.microsoft.com",    "207.126.99.140");
        st.put("www.dell.com",         "143.166.224.230");
        st.put("www.slashdot.org",     "66.35.250.151");
        st.put("www.espn.com",         "199.181.135.201");
        st.put("www.weather.com",      "63.111.66.11");
        st.put("www.yahoo.com",        "216.109.118.65");


        System.out.println("cs.princeton.edu:  " + st.get("www.cs.princeton.edu"));
        System.out.println("hardvardsucks.com: " + st.get("www.harvardsucks.com"));
        System.out.println("simpsons.com:      " + st.get("www.simpsons.com"));
        System.out.println("apple.com:         " + st.get("www.apple.com"));
        System.out.println("ebay.com:          " + st.get("www.ebay.com"));
        System.out.println("dell.com:          " + st.get("www.dell.com"));
        System.out.println();

        System.out.println("size:    " + st.size());
        System.out.println("height:  " + st.height());
        System.out.println(st);
        System.out.println();
    }
}
