package Note0818_Annotation.annotation5;

public class ReflectAnnotationTest {
    public static void main(String[] args) throws Exception{
        //获取这个类
        Class c = Class.forName("Note0818_Annotation.annotation5.MyAnnotationTest");
        //判断类上面是否有@MyAnnotation
        System.out.println(c.isAnnotationPresent(MyAnnotation.class));//true
        if (c.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation myAnnotation = (MyAnnotation) c.getAnnotation(MyAnnotation.class);
            System.out.println("类上面的注解对象"+myAnnotation);//@Note0818.annotation5.MyAnnotation(value=上海浦东区)
            //获取注解对象的属性怎么办？和调接口没区别。
            String value = myAnnotation.value();
            System.out.println(value);//上海浦东区
        }

        //判断String类上面是否存在这个注解
        Class stringClass = Class.forName("java.lang.String");
        System.out.println(stringClass.isAnnotationPresent(MyAnnotation.class));//false
    }
}
