import java.util.ArrayList;

/**
 * 线程的方法
 * 1.start():启动当前线程,调用当前线程的run()方法
 * 2.run():通常需要重写thread类的run方法，将创建的线程要执行的操作声明在此方法中
 * 3.currentThread():静态方法，返回执行当前代码的线程
 * 4.getName():获取当前线程的名字
 * 5.setName():设置当前线程的名字
 * 6.yield():释放当前CPU的执行权
 * 7.join():在线程a中调用线程b的join方法，暂停执行线程a（进入阻塞状态），先执行完线程b，再执行线程a（阻塞状态结束），当其他线程执行完毕，再执行当前线程的方法
 * 8.stop
 * 9.sleep():指定睡眠多少毫秒
 * 10.isAlive():线程是否存活
 *
 * ======================================================================
 * 线程的优先级
 * MIN_PRIORITY = 1;
 * NORM_PRIORITY = 5;
 * MAX_PRIORITY = 10;
 *
 * getPriority():获取优先级
 * setPriority(int i):设置优先级
 */
public class Thread_Methods {
    public static void main(String[] args) {
        Method_Thread methodThread = new Method_Thread();
        methodThread.setName("线程一：");
        methodThread.start();
        methodThread.getPriority();
        methodThread.setPriority(6);
        for (int j =1;j <= 100;j++) {
            if(j %2 != 0) {
                System.out.println(java.lang.Thread.currentThread().getName()+"奇数："+j);
            }
//            if (j == 20) {
//                try {
//                    methodThread.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}

class Method_Thread extends java.lang.Thread{

//    public MyThraed(String name) {
//        super(name);
//    }

    @Override
    public void run() {
        for (int j =1;j <= 100;j++) {
            if(j %2 == 0) {
                System.out.println(java.lang.Thread.currentThread().getName()+j);
            }

//            if (j == 50) {
//                yield();
//            }

            if( j == 60) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
