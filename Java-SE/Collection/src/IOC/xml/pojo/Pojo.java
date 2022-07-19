package IOC.xml.pojo;

import java.util.Objects;

public class Pojo {
    public String name;
    public int age;

    public Pojo() {
    }

    public Pojo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "IOC.xml.pojo.Pojo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pojo pojo = (Pojo) o;
        return age == pojo.age &&
                Objects.equals(name, pojo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
