package Note0818_Annotation.annotation;

public class AnnotationTest03 {
    public static void main(String[] args) {
        AnnotationTest03 at = new AnnotationTest03();
        at.doSome();
    }

    @Deprecated
    public  void doSome(){
        System.out.println("do something!");
    }

    @Deprecated
    public static void doOther(){
        System.out.println("do Other...");
    }
}

class t{
    public static void main(String[] args) {
        AnnotationTest03 at = new AnnotationTest03();
        at.doSome();

        AnnotationTest03.doOther();
    }
}
