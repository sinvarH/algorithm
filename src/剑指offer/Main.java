package 剑指offer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] data = new String[n];
        for (int i = 0;i<n;i++){
            data[i] = "2018."+sc.next();
        }
        System.out.println(Arrays.toString(data));
        //有效的打卡数
        List<String> list = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.mm.dd hh:mm:ss");
        Date date = format.parse("2018.08.10 01:00:00");
        Date date2 = format.parse("2018.08.11 01:00:00");

        System.out.println(date2.getTime()-date.getTime());
    }
}