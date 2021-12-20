package stopthreads;

/**
 * run方法不能抛出异常，只能进行try/catch
 */
public class RunThrowException {

    public void aVoid() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        new Thread(() -> {
            /*throw new Exception();*/
        });
    }
}
