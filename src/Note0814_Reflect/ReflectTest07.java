package Note0814_Reflect;

import java.lang.reflect.Field;

/*
必须掌握：
    怎么通过反射机制访问一个java对象的属性？
        给属性赋值
 */
public class ReflectTest07 {
    public static void main(String[] args) throws Exception{
        //我们不使用反射机制，怎么去访问一个对象的属性呢？
        Student s = new Student();
        //给属性赋值
        s.no=1111;//三要素：给s对象的no属性赋值1111
                  //要素1：对象s
                  //要素2：no属性
                  //要素3：1111
        //读属性值
        //两个要素：获取s对象的no属性的值
        System.out.println(s.no);//1111

        //使用反射机制，怎么去访问一个对象的属性。（set get）
        Class studentClass=Class.forName("Note0814_Reflect.Student");
        Object obj=studentClass.newInstance();//obj就是Student对象。（底层调用无参数构造方法）

        //获取no属性(根据属性的名称来获取Field)
        Field nofield=studentClass.getDeclaredField("no");
        Field[] nofield1=studentClass.getDeclaredFields();
        for (Field nofied:nofield1){
            System.out.println(nofied.getName());
        }
        System.out.println("_________________");
        Field[] nofield2=studentClass.getFields();
        for (Field nofiel:nofield2){
            System.out.println(nofiel.getName());
        }
        System.out.println(nofield2.length);

        //给obj对象(Student对象)的no属性赋值
        /*
        虽然使用了反射机制，但是三要素还是缺一不可
        注意：反射机制让代码复杂了，但是为了一个"灵活"，也是值得的。
         */
        nofield.set(obj,22222);//给obj对象的no属性赋值2222

        //读取属性的值
        //两个要素：虎丘obj对象的no属性的值
        System.out.println(nofield.get(obj));//22222

        //可以访问私有的属性吗？
        Field nameField=studentClass.getDeclaredField("name");
        //打破封装（反射机制的缺点：打破封装，可能会给不法分子留下机会！！！）
        //这样设置完之后，在外部也是可以访问private的。
        nameField.setAccessible(true);
        //给name属性赋值
        nameField.set(obj,"jackson");
        //获取name属性的值
        System.out.println(nameField.get(obj));//jackson
    }
}
