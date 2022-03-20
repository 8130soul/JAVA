import java.util.Scanner;

/**
 * 一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同
 */
public class Work08 {
    public static void main(String[] args) {
        System.out.println("输入一个五位数：");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String str = Long.toString(num);
        char[] chars = str.toCharArray();
        boolean flag = true;

        for (int i=0;i<chars.length/2;i++) {
            if (chars[i]!=chars[chars.length-1-i]) {
                flag = false;
            }
        }
        if (flag) {
            System.out.println("这是一个回文数");
        }else {
            System.out.println("这不是一个回文数");
        }
    }
}
