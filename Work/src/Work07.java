/**
 * 有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和
 */
public class Work07 {
    public static void main(String[] args) {
        double sum = 0,a = 1,b = 1,temp = 0;
        for(int i = 1;i <= 20;i++) {
            temp=b;
            b=a;
            a=a+temp;
            sum+=a/b;
        }
        System.out.println(sum);
    }
}
