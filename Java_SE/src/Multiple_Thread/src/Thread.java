import java.util.ArrayList;

/**
 * 多线程的创建
 * 方式一：继承于thread类
 * 1.创建继承thread类的子类
 * 2.重写thread类的run方法
 * 3.创建子类的对象
 * 4.调用thread类的start方法
 */
public class Thread  {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        MyThread myThread2 = new MyThread();
        myThread2.start();
        for (int i =1;i <= 100;i++) {
            if(i %2 != 0) {
                myThread.arrayList2.add(i);
            }
        }
        System.out.println(java.lang.Thread.currentThread().getName()+"奇数："+myThread.arrayList2.get(0));
        System.out.println(java.lang.Thread.currentThread().getName()+"奇数："+myThread.arrayList2.get(2));
        System.out.println(java.lang.Thread.currentThread().getName()+"奇数："+myThread.arrayList2.get(4));
    }
}

class MyThread extends java.lang.Thread {

    ArrayList arrayList1 = new ArrayList();
    ArrayList arrayList2 = new ArrayList();
    @Override
    public void run() {
        for (int i =1;i <= 100;i++) {
            if(i %2 == 0) {
                arrayList1.add(i);
            }
        }
        System.out.println(java.lang.Thread.currentThread().getName()+" "+"偶数："+arrayList1);
    }
}
