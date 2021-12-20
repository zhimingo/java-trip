package createthreads;

/**
 * Better
 */
public class RunnableStyle implements Runnable {

    @Override
    public void run() {
        System.out.println("用Runnable方法实现线程");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }
}
