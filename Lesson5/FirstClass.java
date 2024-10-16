package reflection;

public class FirstClass {
    private void privateMethod() {
        System.out.println("Вызов privateMethod");
        }
    private void privateMethod2(int m) {
       System.out.println("Вызов privateMethod2");
    }

    protected void protectedMethod() {
       System.out.println("Вызов protectedMethod");
    }

    public void publicMethod() {
       System.out.println("Вызов publicMethod");
    }

    void defaultMethod() {
       System.out.println("Вызов defaultMethod");
    }

}
