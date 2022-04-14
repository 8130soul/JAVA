/**
 * 创建多线程
 * 方式二:实现Runnable接口
 * 1.创建一个实现了Runnable接口的类
 * 2.实现类再去实现Runnable接口的抽象方法：run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.Thread类调用start()
 *
 * =============================================
 * 比较创建多线程的两种方式
 * 开发中，优先选择Runnable接口方式
 * 1.实现的方式没有类的单继承的局限性
 * 2.实现的方式更适合来处理多个线程共享数据的情况
 *
 * 联系:都实现了Runnable接口
 * 相同点:都重写了run方法
 */
public class Thread_Two {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        java.lang.Thread thread =new java.lang.Thread(myThread2);
        thread.start();
    }
}

class MyThread2 implements Runnable{
    @Override
    public void run() {
        for (int j =1;j <= 100;j++) {
            if(j %2 == 0) {
                System.out.println(java.lang.Thread.currentThread().getName()+" "+j);
            }
        }
    }
}
