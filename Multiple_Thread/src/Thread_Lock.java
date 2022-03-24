import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步方式三:   Lock锁
 */
public class Thread_Lock {
    public static void main(String[] args) {
        Tickets ticket = new Tickets();

        java.lang.Thread thread1 = new java.lang.Thread(ticket);
        java.lang.Thread thread2 = new java.lang.Thread(ticket);
        java.lang.Thread thread3 = new java.lang.Thread(ticket);

        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class Tickets implements Runnable{
    int tickets = 100;
    ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (tickets > 0) {
                    try {
                        java.lang.Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(java.lang.Thread.currentThread().getName() + "卖票,票号" + tickets);
                    tickets--;
                }else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
