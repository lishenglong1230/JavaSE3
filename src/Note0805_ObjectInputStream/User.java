package Note0805_ObjectInputStream;

import java.io.Serializable;

public class User implements Serializable {
    private int no;
    //transient关键字表示游离的，不参与序列化
    private transient String name;// name不参与序列化操作！

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(int no, String name) {
        this.no = no;
        this.name = name;
    }
}
