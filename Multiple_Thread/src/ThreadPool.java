import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程
 */
public class ThreadPool {
    public static void main(String[] args) {
        //提供指定数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //执行指定的线程的操作
        service.execute(new NumbelTest());  //适用于Runnable方法
//        service.submit();   //适用于callable方法
        service.shutdown();     //关闭线程池
    }
}


class NumbelTest implements Runnable{
    @Override
    public void run() {
        int sum = 0;
        for (int i=0;i<100;i++) {
            if(i%2==0) {
                System.out.println(i);
                sum += i;
            }
        }
    }
}