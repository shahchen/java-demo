import dev.failsafe.RetryPolicy;
import dev.failsafe.RetryPolicyBuilder;

import java.util.Arrays;

public class RetryPolicyDemo {

    public static void main(String[] args) {
        // 针对单个错误
        RetryPolicyBuilder<Object> handle1 = RetryPolicy.builder()
                .handle(Exception.class);

        // 针对多个错误, 支持变参和list
        RetryPolicyBuilder<Object> handle2 = RetryPolicy.builder()
                .handle(NullPointerException.class, NumberFormatException.class);
        RetryPolicyBuilder<Object> handle3 = RetryPolicy.builder()
                .handle(Arrays.asList(NullPointerException.class, NumberFormatException.class));

        // if错误满足条件时
        RetryPolicyBuilder<Object> handle4 = RetryPolicy.builder()
                .handleIf((t) -> false);
        RetryPolicyBuilder<Object> handle5 = RetryPolicy.builder()
                .handleIf((t, u) -> false);

        // 针对结果
        RetryPolicyBuilder<Object> handle6 = RetryPolicy.builder()
                .handleResult(null);

        // if结果满足条件时
        RetryPolicyBuilder<Object> handle7 = RetryPolicy.builder()
                .handleResultIf((t) -> false);

        // 同时针对错误或者结果
        RetryPolicyBuilder<Object> handle8 = RetryPolicy.builder()
                .handle(Exception.class)
                .handleResult(null);

        RetryPolicy.builder()
                .withMaxAttempts(2)
                .withMaxRetries(3);

    }
}
