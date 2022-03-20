/**
 *一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在 第10次落地时，共经过多少米？第10次反弹多高？
 */
public class Work05 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        double h=100;
        double sum=0;
        for(int i=1;i<=10;i++) {
            double r=h/2;
            h=r;
            sum+=2*h;
            System.out.println("第"+i+"次反弹高度："+h);
        }
        sum+=100;
        System.out.println("第10次落地后，经过"+sum+"米");
    }
}
