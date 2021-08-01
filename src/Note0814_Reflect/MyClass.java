package Note0814_Reflect;

public class MyClass{
    //静态代码快在类加载时执行，并且只执行一次。
    static {
        System.out.println("MyClass类的静态代码快执行了！");
    }
}
