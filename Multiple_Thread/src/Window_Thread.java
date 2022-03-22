/**
 * 示例：多窗口卖票   继承Thread类方式
 */
public class Window_Thread {
    public static void main(String[] args) {
        Window_ticket window_ticket = new Window_ticket();
        Window_ticket window_ticket2 = new Window_ticket();
        Window_ticket window_ticket3 = new Window_ticket();

        window_ticket.setName("窗口一");
        window_ticket2.setName("窗口二");
        window_ticket3.setName("窗口三");

        window_ticket.start();
        window_ticket2.start();
        window_ticket3.start();
    }
}


class Window_ticket extends java.lang.Thread {

    public static int tickets = 100;  //静态变量  公用
    @Override
    public void run() {
        while (true) {
            if (tickets>0){
                System.out.println(getName()+"卖票,票号"+tickets);
                tickets--;
            }else {
                break;
            }
        }
    }
}