import java.util.Scanner;

/**
 * 输入两个正整数m和n，求其最大公约数和最小公倍数
 */
public class Work04 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("请输入第一个正整数：");
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();

        System.out.println("请输入第二个正整数：");
        Scanner in2 = new Scanner(System.in);
        int n = in2.nextInt();

        int result = 0;
        int result2 = 0;

        if(m == 0 || n == 0) {
            System.out.println(m==0?m:n);
        }else{
            for (int i = 2;i<=m && i<=n;i++) {
                if (m % i == 0 && n % i == 0) {
                    result = i;
                    result2 = m * n / i;
                }
            }
        }
        System.out.println("最大公约数："+result+",最小公倍数："+result2);
    }

}
