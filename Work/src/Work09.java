import java.util.ArrayList;
import java.util.Scanner;

/**
 * 有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，
 * 问最后留下的是原来第几号的那位有n个人围成一圈，顺序排号。
 * 从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位
 */
public class Work09 {
    public static void main(String[] args) {
        System.out.println("输入一个数：");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        ArrayList list = new ArrayList();

        for (int i = 1; i <= num; i++) {
            list.add(i);
        }
//        System.out.println(list);

        int index = 0;
        while (list.size()>1) {
            index++;
            if (index==3) {
                list.remove(0);
                index = 0;
            } else {
                list.add(list.remove(0));
//                System.out.println(list);
            }
        }
        System.out.println(list.get(index));
    }
}
