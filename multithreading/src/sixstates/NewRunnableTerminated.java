package sixstates;

/**
 * 展示线程的NEW、RUNNABLE、Terminated状态，即使是正在运行，也是
 * Runnable状态，而不是Running
 */
public class NewRunnableTerminated implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        // 打印出NEW的状态
        System.out.println(thread.getState());
        thread.start();
        // 打印出Runnable状态
        System.out.println(thread.getState());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 打印出Runnable的状态
        System.out.println(thread.getState());
    }
}
