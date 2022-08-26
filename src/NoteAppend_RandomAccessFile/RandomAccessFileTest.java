package NoteAppend_RandomAccessFile;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用
 * 1。RandomAccessFile直接继承与java.lang.Object类，实现了DataInput和DataOutput接口
 * 2、RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 * <p>
 * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建
 * 如果写出到的文件存在，则会对原有文件内容进行覆盖。(默认情况下，从头覆盖)
 *
 * @Author: Lishenglong
 * @Date: 2022/5/14 14:05
 */


public class RandomAccessFileTest {
    @Test
    public void test1() {
        //rw 数据不会立即写入磁盘 rwd 数据会立即写入磁盘
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("Test.txt"), "r");
            raf2 = new RandomAccessFile(new File("Test1.txt"), "rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");

        raf1.seek(3);//将指针调到角标为3的位置
        raf1.write("xyz".getBytes());
        raf1.close();

    }

    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");

        raf1.seek(3);//将指针调到角标为3的位置
        //保存指针3后面的所有数据到StringBuilder中
        StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while ((len = raf1.read(buffer)) != -1) {
            builder.append(new String(buffer,0,len));
        }
        //调回指针3
        raf1.seek(3);
        raf1.write("xyz".getBytes());

        raf1.write(buffer.toString().getBytes());

    }
}
