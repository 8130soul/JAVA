import java.util.Scanner;

public class Work01 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("请输入当月利润：");
        Scanner in = new Scanner(System.in);
        int profit = in.nextInt();
        int bonus = 0;
        if(profit<=10) {
            bonus+=profit*0.1;
        }else if(profit>10 && profit<20){
            bonus+=10*0.1+(profit-10)*0.75;
        }else if(profit>20 && profit<40){
            bonus+=(profit-20)*0.5;
        }else if(profit>40 && profit<60){
            bonus+=(profit-40)*0.3;
        }else if(profit>60 && profit<100){
            bonus+=(profit-60)*0.15;
        }else if(profit>100){
            bonus+=(profit-100)*0.1;
        }
        System.out.println("应发放奖金总数："+bonus);
    }

}
