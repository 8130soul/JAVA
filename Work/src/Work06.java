/**
 * 猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个 。
 * 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下的一半零一个。
 * 到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少
 */
public class Work06 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int sum = 0,result = 1;
        for (int day = 9; day >= 1; day--) {
            sum = (result + 1) * 2;
            result = sum;
            System.out.println("第" + day + "天还剩" + result + "个桃子");
        }
    }
}
