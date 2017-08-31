import java.io.*;
import java.util.HashMap;

/**
 * Created by Administrator on 8/30/2017.
 */
public class Zip {
    private static final int[] pool = new int[256];
    private static final String[] s = {"000","001","010","011","100","101","110","111"};
    public static void main(String[] args) throws IOException {
        long before = System.currentTimeMillis();
        File file = new File("./Fe - Daffodils of Paris.mp3");
            InputStream inputStream;
            //统计出现的次数
            try {
                inputStream = new FileInputStream(file);
                int tempByte;
                while ((tempByte = inputStream.read())!=-1){
                    pool[tempByte]++;
                }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        //构造哈夫曼树
        HuffmanTree huffmanTree = new HuffmanTree(pool);
        HashMap<Integer,String> encodeHashMap = huffmanTree.getencodeMap();
        HashMap<String,Integer> decodeHashMap = huffmanTree.getDecodeMap();

        //压缩
        zip(encodeHashMap,file,"./newzip");

        //解压
        File f = new File("./newzip");
        unZip(decodeHashMap,f,"./newunzip");
        System.out.println("耗时"+(System.currentTimeMillis()-before)/1000+"s");
    }

    /**
     * 进行编码前三位用来表示补0的个数
     * @param encodeHashMap
     * @param file
     * @param path
     * @throws IOException
     */
    static void zip(HashMap<Integer,String>encodeHashMap,File file,String path) throws IOException {
        InputStream inputStream;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            inputStream = new FileInputStream(file);
            int tempByte;
            while ((tempByte = inputStream.read())!=-1){
                stringBuilder.append(encodeHashMap.get(tempByte));
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        int len = stringBuilder.length();

        //需要补0的位数
        int zeroNum = 0;
        if ((len+3)%8!=0)
            zeroNum = 8-(len+3)%8;
        //进行补0
        for (int i = 0;i<zeroNum;i++ ){
            stringBuilder.append('0');
        }


        //加上前面三位标记
        stringBuilder.insert(0,s[zeroNum]);
        String binString = stringBuilder.toString();

        //输出文件
        File f = new File(path);
        OutputStream outputStream ;
        outputStream = new FileOutputStream(f);
        outputStream.write(stringToBit(binString));
    }
    /**
     * 把01字符串转换成01bit
     * @param str
     */
    static byte[] stringToBit(String str){
        int lenSrc = str.length();
        int len01 = lenSrc/8;
        char temp;
        byte[] target = new byte[len01];
        for (int i = 0;i<lenSrc;i++){
            temp = str.charAt(i);
            if (temp=='1'){
                switch (i%8){
                    case 0:
                       target[i/8] = (byte)(target[i/8]|0x80);
                        break;
                    case 1:
                        target[i/8] = (byte)(target[i/8]|0x40);
                        break;
                    case 2:
                        target[i/8] = (byte)(target[i/8]|0x20);
                        break;
                    case 3:
                        target[i/8] = (byte)(target[i/8]|0x10);
                        break;
                    case 4:
                        target[i/8] = (byte)(target[i/8]|0x08);
                        break;
                    case 5:
                        target[i/8] = (byte)(target[i/8]|0x04);
                        break;
                    case 6:
                        target[i/8] = (byte)(target[i/8]|0x02);
                        break;
                    case 7:
                        target[i/8] = (byte)(target[i/8]|0x01);
                        break;
                }

            }
        }
        return target;
    }

    /**
     *
     * @param decodeHashMap
     * @param path
     * @throws IOException
     */
    static void unZip(HashMap<String, Integer> decodeHashMap,File f,String path) throws IOException {
        byte[] data = FileToByteArray(f);
        String binToString = bitToString(data);
        int total = 0;

        //以后在压缩文件添加这个数值
        for (int i = 0;i<pool.length;i++)
            total+=pool[i];
        byte[] bytes = new byte[total];
        int start =0;
        String temp;
        int bytesNum = 0;

       //根据字符串找到对应的编码
        for (int i = 0;i<=binToString.length();i++){
            temp = binToString.substring(start,i);
            if (decodeHashMap.get(temp)!=null){
                bytes[bytesNum++] = (byte)decodeHashMap.get(temp).intValue();
                start=i;
            }
        }

        //输出文件
        File file = new File(path);
        OutputStream outputStream ;
        outputStream = new FileOutputStream(file);
        outputStream.write(bytes);

    }

    /**
     * 把二进制转化为字符串“01”的形式
     * @param data
     * @return String
     */
    static String bitToString(byte[] data){
        int dataLen  = data.length;
        StringBuilder stringBuilder = new StringBuilder(dataLen);
        int strLen = dataLen*8;
        //先把bit转化成string
        for (int i = 0;i<dataLen;i++){
            int x = 0x80;
            for (int j = 0;j<8;j++){
                if ((data[i]&x)!=0)
                    stringBuilder.append('1');
                else
                    stringBuilder.append('0');
                x>>=1;
            }
        }
        //多少位是补零
        int zeroNum = 0;
        String zero = stringBuilder.substring(0,3);
        for (int i = 0;i<s.length;i++){
            if (zero.equals(s[i])) {
                zeroNum = i;
                break;
            }
        }
        //去掉头部三个和后面补零的
        stringBuilder.delete(0,3);
        stringBuilder.delete(stringBuilder.length()-zeroNum,stringBuilder.length());
        return stringBuilder.toString();
    }

    /**
     * 把文件转化为Byte数组
     * @param f
     * @return
     * @throws IOException
     */
    static byte[] FileToByteArray(File f) throws IOException {
        InputStream inputStream;
        long fLen = f.length();
        byte[] bytes = null;
        if (fLen<Integer.MAX_VALUE) {
            bytes = new byte[(int) fLen];
            int offset = 0;
            int numRead = 0;
            inputStream = new FileInputStream(f);
            while (offset<fLen&&(numRead=inputStream.read(bytes,offset,((int) fLen)-offset))>=0){
                offset+=numRead;
            }
            if (offset!=fLen){
                System.out.println("file len errot ");
            }

        }else {
            System.out.println("文件大小超出限制");
        }
        return bytes;
    }
}
