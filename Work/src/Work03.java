/**
 * 水仙花数 一个三位数，其各位数字立方和等于该数本身
 */
public class Work03 {
    public static void main(String[] args) {

        for (int i = 100; i <= 999; i++) {
            int a,b,c;
            a = i / 100;
            b = i / 10 % 10;
            c = i % 10;

            if (Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3)==i) {
                System.out.println(i+"是一个水仙花数："+i);
            }
        }
    }
}
