/**
 * 示例：多窗口卖票   实现Runnable接口方式
 */
public class Window_Thread_Two {
    public static void main(String[] args) {
        Window_ticket_two window_ticket_two = new Window_ticket_two();
        java.lang.Thread thread = new java.lang.Thread(window_ticket_two);
        java.lang.Thread thread2 = new java.lang.Thread(window_ticket_two);
        java.lang.Thread thread3 = new java.lang.Thread(window_ticket_two);

        thread.start();
        thread2.start();
        thread3.start();
    }
}

class Window_ticket_two implements  Runnable{
    int tickets = 100;
    @Override
    public void run() {
        while (true) {
            if (tickets>0){
                System.out.println(java.lang.Thread.currentThread().getName()+"卖票,票号"+tickets);
                tickets--;
            }else {
                break;
            }
        }
    }
}
