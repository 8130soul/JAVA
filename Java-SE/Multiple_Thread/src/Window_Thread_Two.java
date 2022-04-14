/**
 * 示例：多窗口卖票   实现Runnable接口方式
 */
public class Window_Thread_Two {
    public static void main(String[] args) {
        Window_ticket_two window_ticket_two = new Window_ticket_two();
        java.lang.Thread thread = new java.lang.Thread(window_ticket_two);
        java.lang.Thread thread2 = new java.lang.Thread(window_ticket_two);
        java.lang.Thread thread3 = new java.lang.Thread(window_ticket_two);

        thread.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread.start();
        thread2.start();
        thread3.start();
    }
}

class Window_ticket_two implements Runnable {
    int tickets = 100;
    Object object = new Object();

    @Override
    public void run() {
        while (true) {
            //同步  代码块  解决线程安全问题
//            synchronized (object) {
            synchronized (this) {
                if (tickets > 0) {
                    try {
                        java.lang.Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(java.lang.Thread.currentThread().getName() + "卖票,票号" + tickets);
                    tickets--;
                } else {
                    break;
                }
            }
        }
    }
}
