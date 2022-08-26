package NoteAppend_JDK8New.demo03functionalinterface;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Supplier;

/**
 * @Author: Lishenglong
 * @Date: 2022/8/26 17:30
 */
public class Demo02Supplier {

    public static void main(String[] args) {
        //使用Lambda表达式返回数组元素最大值
        printMax(() -> {
            int[] arr = {11, 99, 88, 77, 22};
            Arrays.sort(arr);
            return arr[arr.length - 1];
        });
    }

    public static void printMax(Supplier<Integer> supplier) {
        Integer integer = supplier.get();
        System.out.println("max = " + integer);
    }
}
