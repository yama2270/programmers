public class Main {
    public static void main(String[] args) {

        // static class
        System.out.println(StaticClassTest.staticField);
        StaticClassTest.staticMethod();

        System.out.println(new StaticClassTest().nonStaticField);
        new StaticClassTest().nonStaticMethod();

        // non-static class
        System.out.println(NonStaticClassTest.staticField);
        NonStaticClassTest.staticMethod();

        Main mainClass = new Main();
        System.out.println(mainClass.new NonStaticClassTest().nonStaticField);
    }

    static class StaticClassTest {

        private String nonStaticField = "nonStaticField";

        private static String staticField = "staticField";

        public void nonStaticMethod(){
            System.out.println("nonStaticMethod");
        }

        public static void staticMethod(){
            System.out.println("staticMethod");
        }

    }

    class NonStaticClassTest {

        private String nonStaticField = "nonStaticField";

        private static String staticField = "staticField";

        public void nonStaticMethod(){
            System.out.println("nonStaticMethod");
        }

        public static void staticMethod(){
            System.out.println("staticMethod");
        }
    }

}