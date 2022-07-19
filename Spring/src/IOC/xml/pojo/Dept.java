package IOC.xml.pojo;

public class Dept {
    private String dName;

    public void setdName(String dName) {
        this.dName = dName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dName='" + dName + '\'' +
                '}';
    }
}
