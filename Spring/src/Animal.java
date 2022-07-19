public class Animal {
    private String name;
    private String age;
    private String address;

    public void setAddress(String address) {
        this.address = address;
    }

    //基于xml方式注入  第一种方式：通过set方法注入属性
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void test() {
        System.out.println("这是一个动物类:" + name + "," + age+"," + address);
    }
}
