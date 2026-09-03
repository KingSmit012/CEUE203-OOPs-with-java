package MiniTestRunner;
import java.lang.reflect.Method;

public class MiniTestRunner {
    public static void main(String[] args) {
        MyTest tests = new MyTest();

        Method [] methods = tests.getClass().getDeclaredMethods();

        int count = 0;

        for(Method method : methods){
            if(method.isAnnotationPresent(Run.class)){
                try{
                    method.invoke(tests);
                    count ++;
                }catch(Exception e){
                    System.out.println("ERROR running "+method.getName());
                }
            }
        }
        System.out.println("Total tests : "+count);
    }
}
