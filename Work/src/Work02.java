import java.util.Scanner;

/**
 * 学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示
 */
public class Work02 {
    public static void main(String[] args) {
        System.out.println("请输入学生的学习成绩：");
        Scanner in = new Scanner(System.in);
        int score = in.nextInt();

        if (score>=90) {
            System.out.println("这是A学生的学习成绩。");
        }else if (score >= 60 && score <= 89) {
            System.out.println("这是B学生的学习成绩。");
        }else if(score < 60) {
            System.out.println("这是C学生的学习成绩。");
        }else{
            System.out.println("请输入正确的学习成绩(0-100)");
        }
    }
}
