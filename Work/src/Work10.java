import java.util.Scanner;

/**
 * 古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
 * 小兔子长到第三个月后每个月又生一对兔子，
 * 假如兔子都不死，问每个月的兔子总数为多少
 */
public class Work10 {
    public static void main(String[] args) {
        System.out.println("输入月份：");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("第"+num+"个月有兔子："+2*sum(num)+"只");
    }

    public static int sum(int n) {
        if (n <= 2) {
            return  1;
        }
        return sum(n-1)+sum(n-2);
    }
}
