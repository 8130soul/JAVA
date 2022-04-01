/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于java.lang.Enum类
 */
public class EnumeTest1 {
    public static void main(String[] args) {
        Season_one summer = Season_one.SUMMER;
        //toString():返回枚举类对象的名称
        System.out.println(summer.toString());

        //values():返回所有的枚举类对象构成的数组
        Season_one[] values = Season_one.values();
        for (Season_one s:values) {
            System.out.println(s);
            s.show();
        }

        Thread.State[] values1 = Thread.State.values();
        for (Thread.State t:values1) {
            System.out.println(t);
        }

        //valueOf(String objName):返回枚举类中对象名是objName的对象。
        Season_one winter = Season_one.valueOf("WINTER");
        //如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
//        Season1 winter = Season1.valueOf("WINTER1");
        System.out.println(winter);

//        winter.show();
    }
}

interface Info{
    void show();
}

enum  Season_one implements Info{
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("这是SPRING重写的show方法");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("这是SUMMER重写的show方法");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("这是AUTUMN重写的show方法");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("这是WINTER重写的show方法");
        }
    };

    private final String seasonName;
    private final String seasonDesc;

    private Season_one(String seasonName,String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    /*@Override
    public String toString() {
        return "Season_one{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }*/

   /* @Override
    public void show() {
        System.out.println("实现的show方法");
    }*/
}
