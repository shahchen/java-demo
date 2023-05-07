package stream;

/**
 * 流式计算3步骤：
 *      1、创建流
 *      2、数据在流中的转换
 *      3、数据的聚合
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *  实现数据分组
 */
public class GroupingByDemo {
    List<User> users = Arrays.asList(
        new User("张三", 20, 0),
        new User("李四", 18, 1),
        new User("王二", 10, 1),
        new User("麻子", 50, 1),
        new User("赵倩", 22, 0),
        new User("钱多", 34, 0),
        new User("孙子", 47, 1),
        new User("周红", 30, 0)
    );


    /**
     * 使用groupingBy分组 针对某个字段进行分组
     *
     */
    @Test
    public void test1() {
        Map<Integer, List<User>> collect = users.stream().collect(Collectors.groupingBy(User::getGender));
        System.out.println(collect);
    }


    /**
     * 使用groupingBy 针对某个字段的范围进行分组
     */
    @Test
    public void test2() {
        Map<String, List<User>> collect = users.stream().collect(Collectors.groupingBy(user -> {
            if (user.getAge() > 0 && user.getAge() <= 18) {
                return "0-18";
            } else if (user.getAge() > 18 && user.getAge() <= 30) {
                return "19-30";
            } else {
                return "30-";
            }
        }));

        System.out.println(collect);
    }

    /**
     * 分组统计, 传入下游采集器
     */
    @Test
    public void test3() {
        Map<Integer, Long> collect = users.stream().collect(Collectors.groupingBy(User::getGender, Collectors.counting()));
        System.out.println(collect);
    }











    @Data
    @AllArgsConstructor
    class User {
        private String name;
        private int age;
        private int gender;
    }
}
