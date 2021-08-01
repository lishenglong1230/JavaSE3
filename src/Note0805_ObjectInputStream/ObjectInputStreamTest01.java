package Note0805_ObjectInputStream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamTest01 {
    public static void main(String[] args) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students"));
        //开始反序列化，读
        Object obj=ois.readObject();
        //反序列化回来是一个学生对象，所以会调用学生对象的toString方法。
        System.out.println(obj);//Student{no=1111, name='zhangsan'}
        ois.close();
    }
}
