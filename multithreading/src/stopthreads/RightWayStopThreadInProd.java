package stopthreads;

/**
 * 最佳实践：catch了InterruptedException之后优先选择：
 * 在方法签名中抛出异常，那么run()就会强制try/catch
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
    }
}
