import dev.failsafe.Failsafe;
import dev.failsafe.RetryPolicy;
import dev.failsafe.RetryPolicyBuilder;

import java.time.Duration;

public class HelloFailsafe {

    public static int count  = 1;

    public static void throwRuntimeException() {
        System.out.println("try: " + count + ", time: " + System.currentTimeMillis());
        count++;
        throw new RuntimeException("RuntimeException");
    }

    public static String throwRuntimeExceptionAndReturn() {
        System.out.println("try: " + count + ", time: " + System.currentTimeMillis());
        count++;
        if (count == 3) {
            return "success";
        }
        throw new RuntimeException("RuntimeException");
    }

    public static void main(String[] args) {
        RetryPolicyBuilder<Object> builder = RetryPolicy.builder();

        // 重试3次，间隔1s
        RetryPolicy<Object> retryPolicy = RetryPolicy.builder()
                .handle(RuntimeException.class)
                .withDelay(Duration.ofSeconds(1))
                .withMaxRetries(3)
                .build();

        // 无返回值时
        Failsafe.with(retryPolicy).run(HelloFailsafe::throwRuntimeException);
        // 有返回值时
        String res = Failsafe.with(retryPolicy).get(HelloFailsafe::throwRuntimeExceptionAndReturn);
        System.out.println(res);
    }

}
