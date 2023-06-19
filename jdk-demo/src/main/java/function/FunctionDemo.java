package function;

import org.junit.Test;

import java.util.Objects;
import java.util.function.Function;

/**
 *    Function<T, R>接口 R返回类型，T参数类型
 *    1、R apply(T t) 执行内容
 *    2、<V> Function<V, R> compose(Function<? super V, ? extends T> before)  apply之前执行,compose输出作为apply输入
 *    3、<V> Function<T, V> andThen(Function<? super R, ? extends V> after)   apply之后执行,apply输出作为andThen输入
 */
public class FunctionDemo {

    public String getStr() {
        return "hello";
    }

    @Test
    public void testFunction() {
        String str = getStr();

        Function<String, Integer> function = item -> Objects.isNull(item) ? -1 : item.length();

        // 输出"hello"长度 5
        System.out.println(function.apply(str));

        Function<String, String> functionBefore = item -> {
            item = "Hi " + item;
            return item;
        };
        // 输出"Hi hello"长度 8
        System.out.println(function.compose(functionBefore).apply(str));

        Function<Integer, Integer> functionAfter = count -> {
            count += 6;
            return count;
        };
        // 输出"hello"长度+6 11
        System.out.println(function.andThen(functionAfter).apply(str));

        // 输出"Hi hello"长度 8 + 6 = 14
        System.out.println(function.compose(functionBefore).andThen(functionAfter).apply(str));
    }


}
