package Note0814_Reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
作为了解内容：
    反射Method
 */
public class ReflectTest08 {
    public static void main(String[] args) throws Exception{
        //获取类
        Class userServiceClass = Class.forName("Note0814_Reflect.UserService");
        //获取所有Method(包括私有的)
        Method[] methods = userServiceClass.getDeclaredMethods();
        System.out.println(methods.length);//2

        for (Method method:methods){
            //获取修饰符列表
            System.out.println(Modifier.toString(method.getModifiers()));
            //获取方法的返回值类型
            System.out.println(method.getReturnType().getSimpleName());
            //获取方法名
            System.out.println(method.getName());
            //方法的修饰符列表(一个方法的参数可能会有多个)
            Class[] parameterTypes=method.getParameterTypes();
            for (Class parameterType:parameterTypes){
                System.out.println(parameterType.getSimpleName());
            }
        }
    }
}
