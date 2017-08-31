package Oracle官方教程;

/**
 * Created by Administrator on 7/29/2017.
 */
public class HelloRunnable {
    //deadlock
    static class Friend{
        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        private final String name;

        public synchronized void bow(Friend friend){
            System.out.println(this.name+" bow to "+friend.name);
            friend.bowBack(this);
        }
        public synchronized void bowBack(Friend friend){
            System.out.println(this.name + " bow back to" + friend.name);
        }
    }

    public static void main(String[] args) {
        Friend friend1 = new Friend("ben");
        Friend friend2 = new Friend("Mary");
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (true) {
                    count++;
                    System.out.println(count);
                    friend1.bow(friend2);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    friend2.bow(friend1);
                }
            }
        }).start();
    }
}
