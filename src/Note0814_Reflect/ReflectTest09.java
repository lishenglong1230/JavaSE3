package Note0814_Reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
了解一下，不需要掌握
 */
public class ReflectTest09 {
    public static void main(String[] args) throws Exception{
        StringBuilder s = new StringBuilder();
        Class userServiceClass = Class.forName("Note0814_Reflect.UserService");
        s.append(Modifier.toString(userServiceClass.getModifiers())+" class "+userServiceClass.getSimpleName()+"{\n");

        Method[] methods = userServiceClass.getDeclaredMethods();
        for (Method method:methods){
            //public boolean login(String name,String password){}
            s.append("\t");
            s.append(Modifier.toString(method.getModifiers()));
            s.append(" ");
            s.append(method.getReturnType().getSimpleName());
            s.append(" ");
            s.append(method.getName());
            s.append("(");
            //参数列表
            Class[] parameterTypes = method.getParameterTypes();
            for (Class parameterType : parameterTypes){
                s.append(parameterType.getSimpleName());
                s.append(",");
            }
            //删除指定下标位置上的字符
            s.deleteCharAt(s.length()-1);
            s.append("){}\n");
        }
        s.append("}");
        System.out.println(s);


    }
}
