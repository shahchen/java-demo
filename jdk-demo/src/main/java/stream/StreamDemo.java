package stream;


import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream 是对集合（Collection）对象功能的增强，提供对集合对象进行类似SQL的进行聚合操作。
 *
 *
 */
public class StreamDemo {

    //----------------------------创建Stream对象-------------------------------
    @Test
    public void test() {
        // Stream<T> Stream.empty()
        Stream<Object> emptyStream = Stream.empty();
        // Stream<T> Stream.of(T t)
        Stream<String> zhao = Stream.of("zhao");
        // Stream<T> Stream.of(T... values)
        Stream<String> stream1 = Stream.of("zhao", "qian", "sun", "li");
        Stream.Builder<Object> builder = Stream.builder();



        // Stream.ofNullable(T t)
//        Stream.ofNullable("zhao");

    }


}
