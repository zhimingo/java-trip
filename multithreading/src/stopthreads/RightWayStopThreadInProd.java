package stopthreads;

/**
 * 最佳实践：catch了InterruptedException之后优先选择：
 * 在方法签名中抛出异常，那么run()就会强制try/catch
 * 响应中断的方法总结列表：
 * Object.wait()/wait(long)/wait(long,int)
 * Thread.sleep(long)/sleep(long,int)
 * Thread.join()/join(long)/join(long,int)
 * java.util.concurrent.BlockingQueue.take()/put(E)
 * java.util.concurrent.locks.Lock.lockInterruptibly()
 * java.util.concurrent.CountDownLatch.await()
 * java.util.concurrent.CyclicBarrier.await()
 * java.util.concurrent.Exchanger.exchange(V)
 * java.nio.channels.InterruptibleChannel相关方法
 * java.nio.channels.Selector的相关方法
 *
 * Thread.interrupted() 判断当前线程是否被中断，同时会清除中断标志位
 * 此处的线程是当前运行的线程
 *
 * thread.isInterrupted() 判断当前线程对象是否被中断，不会清除中断标志位
 */
public class RightWayStopThreadInProd implements Runnable {

    @Override
    public void run() {
        if (true && !Thread.currentThread().isInterrupted()) {
            System.out.println("Go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                System.out.println("保存日志");
                e.printStackTrace();
            }
        }
    }

    private void throwInMethod() throws InterruptedException {
        Thread.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        Thread.currentThread().isInterrupted();
    }
}
