package startthread;

/**
 * 同一个线程不能启动两次
 */
public class CannotStartTwice {

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }
}
