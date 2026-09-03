package MiniTestRunner;

public class MyTest {
    @Run
    public void testOne(){
        System.out.println("Test One is running...!");
    }
    
    @Run
    public void testTwo(){
        System.out.println("Test Two is running...!");
    }

    public void normalMethod(){
        System.out.println("Normal Method");
    }

    @Run
    public void testThree(){
        System.out.println("Test Three is running...!");
    }
    
}
