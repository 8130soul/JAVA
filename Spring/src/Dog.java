public class Dog {
    private String name;
    private String age;

    public Dog(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void test() {
        System.out.println("这是一个Dog类:"+name+","+age);
    }
}
