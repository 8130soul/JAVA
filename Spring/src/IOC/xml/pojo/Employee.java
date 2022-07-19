package IOC.xml.pojo;

public class Employee {
    private String eName;
    private String gender;

    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void test() {
        System.out.println("eName=" + eName + '\'' + ", gender='" + gender + '\'' +", dept=" + dept);
    }
}
