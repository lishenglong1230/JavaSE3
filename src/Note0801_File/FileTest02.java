package Note0801_File;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
File类的常用方法
 */
public class FileTest02 {
    public static void main(String[] args) {
        File f1=new File("F:\\123.txt");
        //获取文件名
        System.out.println("文件名:"+f1.getName());//文件名:123.txt

        //判断是否是一个目录
        System.out.println(f1.isDirectory());//false
        //判断是否是一个文件
        System.out.println(f1.isFile());//true

        //获取文件最后一次修改时间
        long haoMiao = f1.lastModified();
        System.out.println(haoMiao);//1596190182379
        //将毫秒数转换成日期？
        Date time=new Date(haoMiao);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String strTime=sdf.format(time);
        System.out.println(strTime);//2020-07-31 18:09:42 379

        //获取文件大小
        System.out.println(f1.length());//0字节
    }
}
