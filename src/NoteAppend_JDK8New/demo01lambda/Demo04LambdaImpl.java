package NoteAppend_JDK8New.demo01lambda;

public class Demo04LambdaImpl {
    public static void main(String[] args) {
        // 匿名内部类在编译后会形成一个新的类.$
        /*goSwimming(new Swimmable() {
            @Override
            public void swimming() {
                System.out.println("使用匿名内部类实现游泳");
            }
        });*/

        goSwimming(() -> {
            System.out.println("Lambda表达式中的游泳");
        });
    }

    //Lambda表达式会在这个类中新生成一个私有的静态方法
    //Lambda表达式中的代码会放到这个新增的方法中
    /*private static void lambda$main$0() {
        System.out.println("Lambda表达式中的游泳");
    }
*/
    public static void goSwimming(Swimmable swimmable) {
        swimmable.swimming();
    }
}

