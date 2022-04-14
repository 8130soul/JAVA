import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Thread_Callable {
    public static void main(String[] args)  {
        //3.创建callable接口实现类的对象
        Num num = new Num();
        //4.将此对象传递到FutureTask构造器中,创建FutureTask的对象
        FutureTask<Object> objectFutureTask = new FutureTask<Object>(num);
        //5.将FutureTask的对象传递到Thread类的构造器中,创建Thread类的对象，启动start方法
        new java.lang.Thread(objectFutureTask).start();
        try {
            //6.获取call方法的返回值
            Object sum = objectFutureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

//1.创建一个实现Callable的实现类
class Num implements Callable<Object>{
    //2.实现call方法，将此线程需要执行的操作声明在call()方法中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i=0;i<100;i++) {
            if(i%2==0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
